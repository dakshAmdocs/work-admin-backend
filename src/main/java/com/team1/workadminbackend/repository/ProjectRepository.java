package com.team1.workadminbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.team1.workadminbackend.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

}
