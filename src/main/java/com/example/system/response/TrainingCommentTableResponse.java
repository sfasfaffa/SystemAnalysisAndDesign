package com.example.system.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingCommentTableResponse {
    //private TrainingCommentSummary trainingCommentSummary;
    private Integer trainingCommunitySummaryId;

    //private Student student;
    private Integer studentId;

    private String stuName;

    private String trainingPlanName;

    private Integer trainingSatisfaction;

    private String suggestions;
}
