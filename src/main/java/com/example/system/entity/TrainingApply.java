package com.example.system.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "training_apply")
@Builder
public class TrainingApply {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @JoinColumn(name = "tra_pla_id")
    @OneToOne(mappedBy = "trainingApply",cascade = {CascadeType.DETACH})
    private TrainingPlan trainingPlan;
    @Column
    private String companyName;
    @Column
    private String phone;
    @Column
    private String trainingContentHope;
    @Column
    private String trainingTimeHope;
    @Column
    private String trainingTarget;
    @Column
    private Integer participantNum;
    @Column
    private BigDecimal budget;
    @Column
    private String comment;
}
