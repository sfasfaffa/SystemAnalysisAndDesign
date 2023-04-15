package com.example.system.response;

import com.example.system.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingPlanResponse {

    private Integer id;


    private String lecturerName;

    private String courseName;


    private String skillStack;

    private String trainingGoal;

    private String trainingContentComment;

    private BigDecimal unitFee;

    private BigDecimal totalFee;

    private String trainingFeeComment;

    private Integer trainingNum;

    private String startTime;

    private String endTime;

    private String trainingPlace;

    private Integer executorId;

    private String executorName;
}
