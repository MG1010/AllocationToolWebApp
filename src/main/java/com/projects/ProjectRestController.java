package com.projects;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectRestController {

    private final ProjectRepository repository;

    public ProjectRestController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/api/projects")
    public List<Project> retrieveAllProjects() {
        return repository.findAll();
    }

    @GetMapping(value = "/api/projects/{id}")
    public Project retrieveProjectById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping(value = "/api/addproject")
    public Project addProject(@RequestBody Project newProject) {
        return repository.save(newProject);
    }

    @PutMapping("/api/projects/{id}")
    public Project updateProject(@RequestBody Project newProject, @PathVariable int id) {

        Project project = repository.findById(id);

        project.setName(newProject.getName());
        project.setDescription(newProject.getDescription());

        return repository.save(project);
    }

    @DeleteMapping("/api/projects/{id}")
    void deleteProject(@PathVariable int id) {
        repository.deleteById(id);
    }


}
