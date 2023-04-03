package com.example.systemanalysisanddesign.entity;


import lombok.*;


import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

    /**
     * id（自动顺序生成）
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;
    @jakarta.persistence.Column
    private String name;
    @jakarta.persistence.Column
    private String pwd;
    @jakarta.persistence.Column
    private String perms;

}
