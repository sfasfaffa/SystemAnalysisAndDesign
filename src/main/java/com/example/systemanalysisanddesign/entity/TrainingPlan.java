package com.example.systemanalysisanddesign.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class TrainingPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<LecturerTrainingPlan> lecturerTrainingPlanList;

    private String course_name;

    @OneToOne
    private TrainingContent trainingContent;

    @OneToOne
    private TrainingFee trainingFee;

    @OneToOne
    private TrainingApply trainingApply;

    @OneToOne
    private TrainingCommentSummary trainingCommentSummary;

    @OneToMany
    private List<RegisterTable> registerTableList;

    @OneToMany
    private List<SignInTable> signInTableList;

    private Integer trainingNum;

    private Timestamp startTime;

    private Timestamp endTime;

    private List<Timestamp> lessonTime;

    private Integer totalLearnTime;

    private String trainingPlace;

}
