package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrainingApply {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @JoinColumn(name = "tra_pla_id")
    @OneToOne
    private TrainingPlan trainingPlan;
    @Column
    private String companyName;
    @Column
    private String phone;
    @Column
    private String trainingContentHope;
    @Column
    private String trainingTimeHope;
    @Column
    private String trainingTarget;
    @Column
    private Integer participantNum;
    @Column
    private BigDecimal budget;
    @Column
    private String comment;
}
