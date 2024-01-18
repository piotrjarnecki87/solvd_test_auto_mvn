package com.solvd.course.hm.project.it.company.dao.daoImpl;

import com.solvd.course.hm.project.it.company.ConnectionConsumer;
import com.solvd.course.hm.project.it.company.ConnectionPool;
import com.solvd.course.hm.project.it.company.dao.GenericDao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class AbstractJdbcDao<T> implements GenericDao<T> {
    private static final ConnectionConsumer connConsumer = new ConnectionConsumer(new CountDownLatch(1));

    public AbstractJdbcDao() {
        connConsumer.run();
    }

    protected Connection getConnection() throws SQLException {
        return ConnectionPool.getInstance().getConnectionAsync().join().getConnection();
    }

    @Override
    public T getById(Connection connection, int id, Class<T> clazz, String tableName, String idColumnName) throws SQLException {
        String query = "SELECT * FROM " + tableName + " WHERE " + idColumnName + " = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToEntity(resultSet, clazz);
                }
            }
        }
        return null;
    }

    @Override
    public List<T> getAll(Connection connection, Class<T> clazz, String tableName) throws SQLException {
        List<T> entities = new ArrayList<>();
        String query = "SELECT * FROM " + tableName;
        try (PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                T entity = mapResultSetToEntity(resultSet, clazz);
                entities.add(entity);
            }
        }
        return entities;
    }

    @Override
    public void insert(Connection connection, T entity, String tableName) throws SQLException {
        Field[] fields = entity.getClass().getDeclaredFields();
        StringBuilder columnNames = new StringBuilder();
        StringBuilder values = new StringBuilder();

        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = field.getName();
            Object value;
            try {
                value = field.get(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field value", e);
            }

            if (value != null) {
                columnNames.append(columnName).append(",");
                values.append("?,");
            }
        }

        if (columnNames.length() > 0) {
            columnNames.deleteCharAt(columnNames.length() - 1);
            values.deleteCharAt(values.length() - 1);
        }

        String query = "INSERT INTO " + tableName + " (" + columnNames + ") VALUES (" + values + ")";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int parameterIndex = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value;
                try {
                    value = field.get(entity);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error accessing field value", e);
                }

                if (value != null) {
                    preparedStatement.setObject(parameterIndex++, value);
                }
            }
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void update(Connection connection, T entity, int id, String tableName, String idColumnName) throws SQLException {
        Field[] fields = entity.getClass().getDeclaredFields();
        StringBuilder updateClause = new StringBuilder();

        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = field.getName();
            Object value;
            try {
                value = field.get(entity);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field value", e);
            }

            if (value != null) {
                updateClause.append(columnName).append("=?,");
            }
        }

        if (updateClause.length() > 0) {
            updateClause.deleteCharAt(updateClause.length() - 1);
        }

        String query = "UPDATE " + tableName + " SET " + updateClause + " WHERE " + idColumnName + " = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            int parameterIndex = 1;
            for (Field field : fields) {
                field.setAccessible(true);
                Object value;
                try {
                    value = field.get(entity);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error accessing field value", e);
                }

                if (value != null) {
                    preparedStatement.setObject(parameterIndex++, value);
                }
            }
            preparedStatement.setInt(parameterIndex, id);
            preparedStatement.executeUpdate();
        }
    }

    @Override
    public void delete(Connection connection, int id, String tableName, String idColumnName) throws SQLException {
        String query = "DELETE FROM " + tableName + " WHERE " + idColumnName + " = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

    private T mapResultSetToEntity(ResultSet resultSet, Class<T> clazz) {
        try {
            T entity = clazz.getDeclaredConstructor().newInstance();
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                String columnName = field.getName(); // Zakładamy, że nazwy kolumn są takie same jak nazwy pól w klasie
                Object value = resultSet.getObject(columnName, field.getType());
                field.set(entity, value);
            }

            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Error mapping result set to entity", e);
        }
    }
}
