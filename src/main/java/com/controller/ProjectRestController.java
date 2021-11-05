package com.controller;

import com.domain.ProjectDTO;
import com.repository.ProjectRepository;
import com.service.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectRestController {

    private final ProjectRepository repository;
    private final ProjectService projectService;

    public ProjectRestController(ProjectRepository repository, ProjectService projectService) {
        this.repository = repository;
        this.projectService = projectService;
    }

    @GetMapping(value = "/api/projects")
    public List<ProjectDTO> getAllProjects() {

        return projectService.getAllProjects();

    }

    @GetMapping(value = "/api/projects/{id}")
    public ProjectDTO getProjectById(@PathVariable int id) {

        return projectService.getProjectById(id);

    }

    @PostMapping(value = "/api/projects")
    void addProject(@RequestBody ProjectDTO newProjectDTO) {

        projectService.addProject(newProjectDTO);

    }

    @PutMapping("/api/projects/{id}")
    void updateProject(@RequestBody ProjectDTO projectDTO, @PathVariable int id) {

        projectService.updateProject(projectDTO);

    }

    @DeleteMapping("/api/projects/{id}")
    void deleteProject(@PathVariable int id) {

        projectService.deleteProject(id);

    }


}
