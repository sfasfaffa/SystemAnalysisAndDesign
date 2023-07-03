package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "email")
@Builder
public class AnswerAndEvaluation {
    @Id
    @Column
    private Integer id;
    @Column
    private Integer uid;
    @Column
    private String question;
    @Column
    private String answer;
    @Column
    private String evaluation;
}
