package com.mapper;

import com.domain.Project;
import com.domain.ProjectDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "client")
    @Mapping(source = "description", target = "note")
    ProjectDto projectToProjectDto(Project project);
}