package com.example.system.request;

import com.example.system.entity.Student;
import com.example.system.entity.TrainingPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInTableRequest {
    private Integer id;
    //private Student student;
    private Integer studentId;
    //private TrainingPlan trainingPlan;
    private Integer trainingPlanId;

    private boolean register;

    private boolean payment;
}
