package com.example.system.entity;

import lombok.*;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrainingPlan {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<LecturerTrainingPlan> lecturerTrainingPlanList;
    @Column
    private String course_name;
    @JoinColumn(name = "tra_con_id")
    @OneToOne
    private TrainingContent trainingContent;
    @JoinColumn(name = "tra_fee_id")
    @OneToOne
    private TrainingFee trainingFee;
    @JoinColumn(name = "tra_app_id")
    @OneToOne
    private TrainingApply trainingApply;
    @JoinColumn(name = "tra_com_sum_id")
    @OneToOne
    private TrainingCommentSummary trainingCommentSummary;

    @OneToMany
    private List<RegisterTable> registerTableList;

    @OneToMany
    private List<SignInTable> signInTableList;
    @Column
    private Integer trainingNum;
    @Column
    private Timestamp startTime;
    @Column
    private Timestamp endTime;
    @Column
    private String trainingPlace;

}
