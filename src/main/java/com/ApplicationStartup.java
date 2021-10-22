package com;

import com.projects.ProjectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationStartup {

    @Autowired
    ProjectDao projectDao;

    @PostConstruct
    public void init() {
        System.out.println("Initialization");

        projectDao.createRecords(20);

        System.out.println("Initialization completed.");
    }
}