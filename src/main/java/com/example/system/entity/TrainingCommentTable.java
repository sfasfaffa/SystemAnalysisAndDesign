package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "training_comment_table")
@Builder
public class TrainingCommentTable {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "tra_com_sum_id")
    @ManyToOne
    private TrainingCommentSummary trainingCommentSummary;
    @JoinColumn(name = "reg_tab_id")
    @OneToOne
    private RegisterTable registerTable;
    @Column
    private Integer trainingSatisfaction;
    @Column
    private String suggestions;
    @Column
    private String stuName;
    @Column
    private String couName;
}
