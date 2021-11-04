package com.repository;

import com.domain.Project;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {

    Project findById(int id);

    @Override
    List<Project> findAll();

    @Override
    void deleteById(@NotNull Integer integer);
}