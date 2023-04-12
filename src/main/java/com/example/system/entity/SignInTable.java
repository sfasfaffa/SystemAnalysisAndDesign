package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

/**
 * 签到表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "sign_in_table")
@Builder
public class SignInTable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "stu_id")
    @ManyToOne
    private Student student;
    @JoinColumn(name = "tra_pla_id")
    @ManyToOne
    private TrainingPlan trainingPlan;
    @Column
    private boolean register;
}
