package com.team1.workadminbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "projectLead")
    private String projectLead;

    @Column(name= "startDate")
    private Date startDate;

    @Column(name= "endDate")
    private Date endDate;

    @Column(name = "status")
    private String status;

    @Column(name = "technologyUsed")
    private String technologyUsed;

    @Column(name = "jiraLink")
    private String jiraLink;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name = "allocationId", referencedColumnName = "id")
    private List<Allocation> theatre;

}
