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
    @Column
    private String name;
    @Column
    private String gender;
    @Column
    private String pwd;
    @Column
    private String perms;
    @Column
    private String stuName;
    @OneToOne
    private Student student;
    @OneToOne
    private Executor executor;

}
