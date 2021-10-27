package com.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProjectDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //Find All Method
    public List<Project> findAll() {
        return jdbcTemplate.query("select * from projects",
                new BeanPropertyRowMapper<Project>(Project.class));
    }

    //Find Projects By Page
    public List<Project> findProjectsByPage(int pageId, int total) {
        return jdbcTemplate.query("select * from projects limit " + (pageId - 1) + ","
                + total, new BeanPropertyRowMapper<Project>(Project.class));
    }

    //findByID - to change list into obj
    public List<Project> findById(int Id) {
        return jdbcTemplate.query("select * from projects where id= " + Id
                , new BeanPropertyRowMapper<Project>(Project.class));
    }

    //add Method
    void add(Project project) {

        jdbcTemplate.update("insert into projects (name, description) " + "values(?, ?)", project.getName(), project.getDescription());

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

}
