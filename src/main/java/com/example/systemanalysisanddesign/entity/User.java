package com.example.systemanalysisanddesign.entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName User
 * @Description 用户
 * @Author pengdengyun
 * @Updater
 * @Create 2022-05-06
 * @Update
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class User {

    /**
     * id（自动顺序生成）
     */
    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @jakarta.persistence.Column(name = "id", nullable = false)
    private Integer id;
    @Column
    private String name;
    @Column
    private String pwd;
    @Column
    private String perms;



}
