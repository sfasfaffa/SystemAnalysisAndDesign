package com.example.system.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterTableResponse {
    //private TrainingPlan trainingPlan;
    private Integer trainingPlanId;

    //private Student student;
    private  Integer TrainingPlanId;

    private String companyName;

    private String post;

    private String technicalLevel;

    private String phone;

    private boolean registerSuccess;

    private boolean feePayment;
}
