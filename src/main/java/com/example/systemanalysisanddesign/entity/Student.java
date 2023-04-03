package com.example.systemanalysisanddesign.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<RegisterTable>registerTableList;

    @OneToOne
    private TrainingCommentTable trainingCommentTable;

    private String name;

    private String gender;

    @OneToMany
    private List<SignInTable> signInTableList;

}
