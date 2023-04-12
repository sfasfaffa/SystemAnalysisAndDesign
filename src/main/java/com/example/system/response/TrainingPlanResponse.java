package com.example.system.response;

import com.example.system.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingPlanResponse {
    private List<LecturerTrainingPlan> lecturerTrainingPlanList;

    private String course_name;

    private TrainingContent trainingContent;

    private TrainingFee trainingFee;

    private TrainingApply trainingApply;

    private TrainingCommentSummary trainingCommentSummary;

    private List<RegisterTable> registerTableList;

    private List<SignInTable> signInTableList;

    private Integer trainingNum;

    private Timestamp startTime;

    private Timestamp endTime;

    private String trainingPlace;
}
