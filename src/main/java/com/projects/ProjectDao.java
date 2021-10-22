package com.projects;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    //Find All Method
    public List<Project> findAll() {
        return jdbcTemplate.query("select * from projects",
                new BeanPropertyRowMapper<Project>(Project.class));
    }

    //Find Projects By Page
    public List<Project> findProjectsByPage(int pageId, int total) {
        return jdbcTemplate.query("select * from projects limit " + (pageId - 1) + "," + total, new BeanPropertyRowMapper<Project>(Project.class));
    }

/*    //getProjectByID Method
    public Project getProjectByID(Integer id) {
        return jdbcTemplate.queryForObject("select * from projects where id=" + id, new Object[]{id},
                new BeanPropertyRowMapper<Project>(Project.class));
    }*/

    //add Method
    void add(Project project) {

        String SQLQuery = "insert into projects values (:id, :name, :description)";

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 4);
        map.put("name", project.getName());
        map.put("description", project.getDescription());

        namedParameterJdbcTemplate.execute(SQLQuery, map, new PreparedStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement preparedStatement) throws SQLException, DataAccessException {
                return preparedStatement.executeUpdate();
            }
        });

//        jdbcTemplate.update("insert into projects (name, description) " + "values(?, ?)", project.getName(), project.getDescription());

    }

    //delete Method
    void delete(int id) {
        jdbcTemplate.update("delete from projects where id=" + id);
    }

    //Create Records Method
    public void createRecords(final Integer NumberOfRowsToBeCreated) {

        final int NumberOfRowsInTable = jdbcTemplate.queryForObject("select count(*) from projects", Integer.class);

        if (NumberOfRowsToBeCreated > NumberOfRowsInTable) {

            int IterationCounter = NumberOfRowsInTable;
            String SQLQueryValues = "";

            do {

                SQLQueryValues = SQLQueryValues + "('ProjectName" + (IterationCounter + 1) + "', 'ProjectDescription" + (IterationCounter + 1) + "')";

                IterationCounter++;

                if (IterationCounter != NumberOfRowsToBeCreated) {
                    SQLQueryValues = SQLQueryValues + ",";
                }

            }
            while (IterationCounter != NumberOfRowsToBeCreated);

            jdbcTemplate.update("INSERT INTO projects ( name, description) VALUES " + SQLQueryValues);

        }


    }

    //Update Method
    /*    public int Update(Project project){
        return jdbcTemplate.update("update projects where id="+id+"");
    }*/
}
