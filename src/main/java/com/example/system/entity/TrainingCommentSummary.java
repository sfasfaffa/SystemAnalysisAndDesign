package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "training_comment_summary")
@Builder
public class TrainingCommentSummary {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<TrainingCommentTable> trainingCommentTableList;
    @Column
    private String satisfactionSummary;
    @Column
    private String suggestionCollect;
}