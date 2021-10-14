package com.projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Project> findAll(){
        return jdbcTemplate.query("select * from projects",
                new BeanPropertyRowMapper<Project>(Project.class));
    }

    }
