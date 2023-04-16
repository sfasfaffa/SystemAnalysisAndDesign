package com.example.system.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInTableResponse {
    //private Student student;
    private String studentName;

    //private TrainingPlan trainingPlan;
    private Integer trainingPlanId;
    private String trainingPlanName;
    private boolean register;
    private boolean payment;
    private Integer id;
}
