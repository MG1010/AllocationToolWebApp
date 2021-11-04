package com.controller;

import com.domain.Project;
import com.repository.ProjectRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

//        //https://www.baeldung.com/spring-hateoas-tutorial
//
//        Project retrievedProject = repository.findById(id);
//
//        Link selfLink = linkTo(ProjectRestController.class)
//                .slash(retrievedProject.getId())
//                .withSelfRel();
//
//        retrievedProject.add(selfLink);

        return repository.findById(id);

    }

    @PostMapping(value = "/api/projects")
    public ResponseEntity<Object> addProject(@RequestBody Project newProject) {
        Project savedProject = repository.save(newProject);

        //https://www.baeldung.com/spring-response-entity

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedProject.getId())
                .toUri();

        return ResponseEntity.created(location).build();

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
