package com.example.system.request;

import com.example.system.entity.TrainingPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingApplyRequest {

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
