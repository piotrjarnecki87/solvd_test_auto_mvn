package com.solvd.course.hm.project.it.company.dao.daoImpl;

import com.solvd.course.hm.project.it.company.CEO;
import com.solvd.course.hm.project.it.company.dao.CEODao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CEODaoImpl extends AbstractJdbcDao <CEO> implements CEODao {

    public CEODaoImpl() {
        super();
    }

    @Override
    protected Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    @Override
    public CEO getById(Connection connection, int id, Class<CEO> clazz, String tableName, String idColumnName) throws SQLException {
        return super.getById(connection, id, clazz, tableName, idColumnName);
    }

    @Override
    public List<CEO> getAll(Connection connection, Class<CEO> clazz, String tableName) throws SQLException {
        return super.getAll(connection, clazz, tableName);
    }

    @Override
    public void insert(Connection connection, CEO entity, String tableName) throws SQLException {
        super.insert(connection, entity, tableName);
    }

    @Override
    public void update(Connection connection, CEO entity, int id, String tableName, String idColumnName) throws SQLException {
        super.update(connection, entity, id, tableName, idColumnName);
    }

    @Override
    public void delete(Connection connection, int id, String tableName, String idColumnName) throws SQLException {
        super.delete(connection, id, tableName, idColumnName);
    }
}
