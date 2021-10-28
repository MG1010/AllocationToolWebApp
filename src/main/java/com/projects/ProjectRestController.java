package com.projects;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProjectRestController {

    private final ProjectRepository repository;

    public ProjectRestController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "api/projects")
    public List<Project> retrieveAllProjects() {
        return repository.findAll();
    }


}
