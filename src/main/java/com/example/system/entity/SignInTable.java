package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

/**
 * 签到表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sign_in_table")
public class SignInTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private TrainingPlan trainingPlan;

    private boolean register;
}
