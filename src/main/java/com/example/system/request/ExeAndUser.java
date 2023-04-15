package com.example.system.request;

import com.example.system.entity.Executor;
import com.example.system.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExeAndUser {
    private Integer id;

    private String name;

    private String pwd;

    private String perms;

    private String ExName;
}
