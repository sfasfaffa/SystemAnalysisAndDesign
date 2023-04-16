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
public class TrainingCommentSummaryResponse {
    //private TrainingPlan trainingPlan;
    private String trainingPlanName;

    private String satisfactionSummary;

    private String suggestionCollect;
}
