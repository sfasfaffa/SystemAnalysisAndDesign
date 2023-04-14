package com.example.system.request;

import com.example.system.entity.RegisterTable;
import com.example.system.entity.Student;
import com.example.system.entity.TrainingCommentSummary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingCommentTableRequest {
    private Integer id;

    private Integer trainingCommunitySummary;

    private Integer studentId;

    private Integer trainingSatisfaction;

    private String suggestions;

    private RegisterTable registerTable;
}
