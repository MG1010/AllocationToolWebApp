package com.service;

import com.domain.Project;
import com.domain.ProjectDTO;
import com.mapper.ProjectMapperImpl;
import com.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository repository;
    private final ProjectMapperImpl projectMapper;

    public ProjectService(ProjectRepository repository, ProjectMapperImpl projectMapper) {
        this.repository = repository;
        this.projectMapper = projectMapper;
    }

    public List<ProjectDTO> getAllProjects() {

        List<Project> listProjects = repository.findAll();
        List<ProjectDTO> listProjectsDTO = new ArrayList<>();

        listProjects.forEach(project -> listProjectsDTO.add(projectMapper.mapToProjectDTO(project)));

        return listProjectsDTO;

    }

    public ProjectDTO getProjectById(int id) {

        return projectMapper.mapToProjectDTO(repository.findById(id));

    }

    public void addProject(ProjectDTO newProjectDTO) {

        repository.save(projectMapper.mapToProject(newProjectDTO));

    }

    public void updateProject(ProjectDTO projectDTO) {

        repository.save(projectMapper.mapToProject(projectDTO));

    } // TO ADD IF STATEMENT/VALIDATION

    public void deleteProject(int id) {

        repository.deleteById(id);

    }
}
