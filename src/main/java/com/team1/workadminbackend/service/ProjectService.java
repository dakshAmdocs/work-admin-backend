package com.team1.workadminbackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.team1.workadminbackend.model.Project;
import com.team1.workadminbackend.repository.ProjectRepository;

import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project addProject(Project project) {
        try {
            return projectRepository.save(project);
        } catch (Exception e) {
            // Handle the exception, log, and potentially perform additional actions
            throw new RuntimeException("Failed to add project: " + e.getMessage());
        }
    }

    public Project updateProject(Long id, Project updatedProject) {
        try {
            Optional<Project> existingProject = projectRepository.findById(id);
            if (existingProject.isPresent()) {
                Project project = existingProject.get();
                project.setName(updatedProject.getName());
                project.setProjectLead(updatedProject.getProjectLead());
                project.setStartDate(updatedProject.getStartDate());
                project.setEndDate(updatedProject.getEndDate());
                project.setStatus(updatedProject.getStatus());
                project.setTechnologyUsed(updatedProject.getTechnologyUsed());
                project.setJiraLink(updatedProject.getJiraLink());

                return projectRepository.save(project);
            }
            return null; // Handle not found case
        } catch (Exception e) {
            // Handle the exception, log, and potentially perform additional actions
            throw new RuntimeException("Failed to update project: " + e.getMessage());
        }
    }
}
