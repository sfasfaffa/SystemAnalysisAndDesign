package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrainingContent {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "tra_pla_id")
    @OneToOne
    private TrainingPlan trainingPlan;
    @Column
    private String skillStack;
    @Column
    private String trainingGoal;
    @Column
    private String comment;
}
