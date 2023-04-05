package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "lecturer_training_plan")
public class LecturerTrainingPlan {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "tra_pla_id")
    @ManyToOne
    private TrainingPlan trainingPlan;
    @JoinColumn(name = "lec_id")
    @ManyToOne
    private Lecturer lecturer;
}
