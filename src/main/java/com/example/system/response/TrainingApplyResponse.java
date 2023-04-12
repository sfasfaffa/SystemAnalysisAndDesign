package com.example.system.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingApplyResponse {
    //private TrainingPlan trainingPlan;
    private Integer trainingPlanId;

    private String companyName;

    private String phone;

    private String trainingContentHope;

    private String trainingTimeHope;

    private String trainingTarget;

    private Integer participantNum;

    private BigDecimal budget;

    private String comment;
}
