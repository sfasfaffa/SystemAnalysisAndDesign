package com.example.system.entity;

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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "tra_pla_id")
    @ManyToOne
    private TrainingPlan trainingPlan;
    @JoinColumn(name = "stu_id")
    @ManyToOne
    private Student student;
    @Column
    private String companyName;
    @Column
    private String post;
    @Column
    private String technicalLevel;
    @Column
    private String phone;
    @Column
    private boolean registerSuccess;
    @Column
    private boolean feePayment;
}
