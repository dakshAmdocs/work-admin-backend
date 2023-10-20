package com.team1.workadminbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "allocation")
public class Allocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employeeId" , referencedColumnName = "id")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "projectId" , referencedColumnName = "id")
    private Project project;

    @Column(name= "startDate")
    private Date startDate;

    @Column(name= "endDate")
    private Date endDate;
}
