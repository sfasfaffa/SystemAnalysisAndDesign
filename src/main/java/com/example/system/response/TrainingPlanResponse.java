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

    //private List<LecturerTrainingPlan> lecturerTrainingPlanList;
    //private Integer lecturerId;

    private String courseName;//

    //private TrainingContent trainingContent;
    private String skillStack;
    private String trainingGoal;
    private String trainingContentComment;

    //private TrainingFee trainingFee;
    private BigDecimal unitFee;
    private BigDecimal totalFee;
    private String trainingFeeComment;

    //private TrainingApply trainingApply;
    //private Integer trainingApplyId;

    //private TrainingCommentSummary trainingCommentSummary;

    //private List<RegisterTable> registerTableList;

    //private List<SignInTable> signInTableList;

    private Integer trainingNum;

    private Timestamp startTime;

    private Timestamp endTime;

    private String trainingPlace;

    private Integer executorId;
}
