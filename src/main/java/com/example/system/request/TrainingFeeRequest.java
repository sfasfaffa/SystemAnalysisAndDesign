package com.example.system.request;

import com.example.system.entity.TrainingPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingFeeRequest {

    //private TrainingPlan trainingPlan;
    private Integer trainingPlanId;

    private String skillStack;

    private String trainingGoal;

    private String comment;
}
