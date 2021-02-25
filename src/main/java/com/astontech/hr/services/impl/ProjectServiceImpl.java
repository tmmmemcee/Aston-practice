package com.astontech.hr.services.impl;

import com.astontech.hr.domain.Project;
import com.astontech.hr.repositories.ProjectRepository;
import com.astontech.hr.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Integer id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Iterable<Project> saveAllProjects(Iterable<Project> projectIterable) {
        return projectRepository.saveAll(projectIterable);
    }

    @Override
    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
    }
}
