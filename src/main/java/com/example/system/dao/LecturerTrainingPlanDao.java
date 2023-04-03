package com.example.system.dao;

import com.example.system.entity.LecturerTrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerTrainingPlanDao extends JpaRepository<LecturerTrainingPlan,Integer> {
}
