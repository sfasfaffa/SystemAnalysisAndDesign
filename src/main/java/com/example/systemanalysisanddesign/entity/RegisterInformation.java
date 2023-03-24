package com.example.systemanalysisanddesign.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class RegisterInformation {
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @jakarta.persistence.Column(name = "id", nullable = false)
    private Integer id;
    @jakarta.persistence.Column
    private String name;
    @jakarta.persistence.Column
    private String pwd;
    @jakarta.persistence.Column
    private String perms;
}
