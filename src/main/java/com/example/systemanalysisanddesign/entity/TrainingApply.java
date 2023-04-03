package com.example.systemanalysisanddesign.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
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
