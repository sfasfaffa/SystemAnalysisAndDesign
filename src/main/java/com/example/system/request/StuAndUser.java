package com.example.system.request;

import com.example.system.entity.Executor;
import com.example.system.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StuAndUser {

    private String name;

    private String gender;

    private String pwd;

    private String perms;

    private String stuName;

    private Student student;

    private Executor executor;

    private String post;
}
