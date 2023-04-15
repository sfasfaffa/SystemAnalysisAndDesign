package com.example.system.request;

import com.example.system.entity.Student;
import com.example.system.entity.TrainingPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterTableRequest {

    //private TrainingPlan trainingPlan;
    private Integer id;

    //private Student student;
    private  Integer trainingPlanId;

    private String companyName;

    private String post;

    private String technicalLevel;

    private String phone;

    private boolean registerSuccess;

    private boolean feePayment;

    private String cause;
}
