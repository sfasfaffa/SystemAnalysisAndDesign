package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ansAndEva")
@Builder
public class AnswerAndEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer uid;
    @Column
    private String question;
    @Column
    private String answer;
    @Column
    private String evaluation;
    @Column
    private Integer s1;
    @Column
    private Integer s2;
    @Column
    private Integer s3;
    @Column
    private Integer s4;
    @Column
    private Integer s5;
}
