package com.solvd.course.hm.project.it.company.dao.daoImpl;

import com.solvd.course.hm.project.it.company.Person;
import com.solvd.course.hm.project.it.company.dao.PersonDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PersonDaoImpl extends AbstractJdbcDao<Person> implements PersonDao {

    public PersonDaoImpl() {
        super();
    }

    @Override
    protected Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    @Override
    public Person getById(Connection connection, int id, Class<Person> clazz, String tableName, String idColumnName) throws SQLException {
        return super.getById(connection, id, clazz, tableName, idColumnName);
    }

    @Override
    public List<Person> getAll(Connection connection, Class<Person> clazz, String tableName) throws SQLException {
        return super.getAll(connection, clazz, tableName);
    }

    @Override
    public void insert(Connection connection, Person entity, String tableName) throws SQLException {
        super.insert(connection, entity, tableName);
    }

    @Override
    public void update(Connection connection, Person entity, int id, String tableName, String idColumnName) throws SQLException {
        super.update(connection, entity, id, tableName, idColumnName);
    }

    @Override
    public void delete(Connection connection, int id, String tableName, String idColumnName) throws SQLException {
        super.delete(connection, id, tableName, idColumnName);
    }
}
