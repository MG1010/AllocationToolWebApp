package com.mapper;

import com.domain.Project;
import com.domain.ProjectDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(source = "projectid", target = "id")
    @Mapping(source = "projectname", target = "name")
    @Mapping(source = "projectdescription", target = "description")

    Project mapToProject(ProjectDTO projectDTO);

    @InheritInverseConfiguration(name = "mapToProject")
    ProjectDTO mapToProjectDTO (Project project);
}