package com.solvd.course.hm.project.it.company.dao.daoImpl;

import com.solvd.course.hm.project.it.company.Employee;
import com.solvd.course.hm.project.it.company.dao.EmployeeDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployeeDaoImpl extends AbstractJdbcDao<Employee> implements EmployeeDao {
    public EmployeeDaoImpl() {
        super();
    }

    @Override
    public Employee getById(Connection connection, int id, Class<Employee> clazz, String tableName, String idColumnName) throws SQLException {
        return super.getById(connection, id, clazz, tableName, idColumnName);
    }

    @Override
    public List<Employee> getAll(Connection connection, Class<Employee> clazz, String tableName) throws SQLException {
        return super.getAll(connection, clazz, tableName);
    }

    @Override
    public void insert(Connection connection, Employee entity, String tableName) throws SQLException {
        super.insert(connection, entity, tableName);
    }

    @Override
    public void update(Connection connection, Employee entity, int id, String tableName, String idColumnName) throws SQLException {
        super.update(connection, entity, id, tableName, idColumnName);
    }

    @Override
    public void delete(Connection connection, int id, String tableName, String idColumnName) throws SQLException {
        super.delete(connection, id, tableName, idColumnName);
    }
}
