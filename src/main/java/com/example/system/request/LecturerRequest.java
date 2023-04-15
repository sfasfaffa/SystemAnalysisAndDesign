package com.example.system.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LecturerRequest {

    //private List<LecturerTrainingPlan> lecturerTrainingPlanList;

    private String name;

    private String position;

    private String speciality;

    private String emailAddress;

    private String phone;

    private Integer id;
}
