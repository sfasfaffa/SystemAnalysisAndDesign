package com.example.systemanalysisanddesign.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<LecturerTrainingPlan> lecturerTrainingPlanList;

    private String name;

    private String position;

    private String speciality;

    private String emailAddress;

    private String phone;
}









