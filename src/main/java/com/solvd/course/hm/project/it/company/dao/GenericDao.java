package com.solvd.course.hm.project.it.company.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface GenericDao<T> {
    T getById(Connection connection, int id, Class<T> clazz, String tableName, String idColumnName) throws SQLException;

    List<T> getAll(Connection connection, Class<T> clazz, String tableName) throws SQLException;

    void insert(Connection connection, T entity, String tableName) throws SQLException;

    void update(Connection connection, T entity, int id, String tableName, String idColumnName) throws SQLException;

    void delete(Connection connection, int id, String tableName, String idColumnName) throws SQLException;
}
