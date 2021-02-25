package com.astontech.hr.services;

import com.astontech.hr.domain.Project;

public interface ProjectService {
    Iterable<Project> getAllProjects();
    Project getProjectById(Integer id);
    Project saveProject(Project project);
    Iterable<Project> saveAllProjects(Iterable<Project> projectIterable);
    void deleteProject(Integer id);
}
