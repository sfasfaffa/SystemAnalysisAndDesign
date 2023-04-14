package com.example.system.request;

import com.example.system.entity.TrainingCommentTable;
import com.example.system.entity.TrainingPlan;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingCommentSummaryRequest {

    private Integer id;

    private List<TrainingCommentTable> trainingCommentTableList;

    private String satisfactionSummary;

    private String suggestionCollect;
}
