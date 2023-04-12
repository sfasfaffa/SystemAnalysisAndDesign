package com.example.system.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingFeeResponse {
    //private TrainingPlan trainingPlan;
    private Integer trainingPlanId;

    private String skillStack;

    private String trainingGoal;

    private String comment;
}
