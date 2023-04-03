package com.example.systemanalysisanddesign.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 报名表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "register_table")
@Builder
public class RegisterTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private TrainingPlan trainingPlan;

    @ManyToOne
    private Student student;

    private String companyName;

    private String post;

    private String technicalLevel;

    private String phone;

    private boolean registerSuccess;

    private boolean feePayment;
}
