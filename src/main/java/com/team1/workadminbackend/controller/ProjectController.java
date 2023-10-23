package com.team1.workadminbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.team1.workadminbackend.model.Project;
import com.team1.workadminbackend.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        try {
            Project newProject = projectRepository.save(project);
            return new ResponseEntity<>(newProject, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
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

                return new ResponseEntity<>(projectRepository.save(project), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
