package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrainingCommentTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private TrainingCommentSummary trainingCommentSummary;

    @OneToOne
    private Student student;

    private Integer trainingSatisfaction;

    private String suggestions;
}
