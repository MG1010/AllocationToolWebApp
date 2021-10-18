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
    public Project GetProjectByID(Integer id){
        return jdbcTemplate.queryForObject("select * from projects where id="+id, new Object[]{id},
                new BeanPropertyRowMapper<Project>(Project.class));
    }

    public int Add(Project project){
        return  jdbcTemplate.update("insert into projects (name, description) " + "values(?, ?)", project.getName(),project.getDescription());
        }
    public int Delete(int id){
        return jdbcTemplate.update("delete from projects where id="+id);
    }
/*    public int Update(Project project){
        return jdbcTemplate.update("update projects where id="+id+"");
    }*/
}
