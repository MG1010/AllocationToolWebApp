package com.projects;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {

    Project findById(int id);

    @Override
    void deleteById(@NotNull Integer integer);
}