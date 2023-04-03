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
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "tra_com_sum_id")
    @ManyToOne
    private TrainingCommentSummary trainingCommentSummary;
    @JoinColumn(name = "stu_id")
    @OneToOne
    private Student student;
    @Column
    private Integer trainingSatisfaction;
    @Column
    private String suggestions;
}
