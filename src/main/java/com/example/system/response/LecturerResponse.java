package com.example.system.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LecturerResponse {
    //private List<LecturerTrainingPlan> lecturerTrainingPlanList;

    private String name;

    private String position;

    private String speciality;

    private String emailAddress;

    private String phone;
}
