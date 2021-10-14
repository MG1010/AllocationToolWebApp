package com.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public class TeamDao {

        @Autowired
        JdbcTemplate jdbcTemplate;

        public List<TeamMember> findAll(){
            return jdbcTemplate.query("select * from team",
                    new BeanPropertyRowMapper<TeamMember>(TeamMember.class));
        }

    }
