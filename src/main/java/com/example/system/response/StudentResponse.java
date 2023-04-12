package com.example.system.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    //private Student student;
    private Integer studentId;

    //private TrainingPlan trainingPlan;
    private Integer trainingPlanId;

    private boolean register;
}
