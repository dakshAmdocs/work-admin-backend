package com.team1.workadminbackend.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@ToString
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "expertise")
    private String expertise;

    @Column(name = "location")
    private String location;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name = "allocationId", referencedColumnName = "id")
    private List<Allocation> allocation;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "employeeId", referencedColumnName = "id")
    private Feedback feedback;
}
