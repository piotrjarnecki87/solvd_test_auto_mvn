package com.solvd.course.hm.project.it.company.dao.daoImpl;

import com.solvd.course.hm.project.it.company.ProjectManager;
import com.solvd.course.hm.project.it.company.dao.ProjectManagerDao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ProjectManagerDaoImpl extends AbstractJdbcDao<ProjectManager> implements ProjectManagerDao {
    public ProjectManagerDaoImpl() {
        super();
    }

    @Override
    protected Connection getConnection() throws SQLException {
        return super.getConnection();
    }

    @Override
    public ProjectManager getById(Connection connection, int id, Class<ProjectManager> clazz, String tableName, String idColumnName) throws SQLException {
        return super.getById(connection, id, clazz, tableName, idColumnName);
    }

    @Override
    public List<ProjectManager> getAll(Connection connection, Class<ProjectManager> clazz, String tableName) throws SQLException {
        return super.getAll(connection, clazz, tableName);
    }

    @Override
    public void insert(Connection connection, ProjectManager entity, String tableName) throws SQLException {
        super.insert(connection, entity, tableName);
    }

    @Override
    public void update(Connection connection, ProjectManager entity, int id, String tableName, String idColumnName) throws SQLException {
        super.update(connection, entity, id, tableName, idColumnName);
    }

    @Override
    public void delete(Connection connection, int id, String tableName, String idColumnName) throws SQLException {
        super.delete(connection, id, tableName, idColumnName);
    }
}
