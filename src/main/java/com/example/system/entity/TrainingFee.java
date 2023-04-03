package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrainingFee {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "tra_pla_id")
    @OneToOne
    private TrainingPlan trainingPlan;
    @Column
    private BigDecimal unitFee;
    @Column
    private BigDecimal totalFee;
    @Column
    private String comment;
}
