package com.example.system.request;

import com.example.system.entity.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingPlanRequest {

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