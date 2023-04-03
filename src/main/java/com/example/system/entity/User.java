package com.example.system.entity;


import jakarta.persistence.*;
import lombok.*;




@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    /**
     * id（自动顺序生成）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String pwd;
    @Column
    private String perms;

}
