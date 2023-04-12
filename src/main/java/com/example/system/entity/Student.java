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
@Entity(name = "student")
@Builder
public class Student {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany
    private List<RegisterTable>registerTableList;

    @OneToOne
    private TrainingCommentTable trainingCommentTable;
    @Column
    private String name;
    @Column
    private String gender;

    @OneToMany
    private List<SignInTable> signInTableList;

}
