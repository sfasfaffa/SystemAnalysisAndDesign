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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @OneToOne
    private TrainingPlan trainingPlan;

    private String companyName;

    private String phone;

    private String trainingContentHope;

    private String trainingTimeHope;

    private String trainingTarget;

    private Integer participantNum;

    private BigDecimal budget;

    private String comment;
}
