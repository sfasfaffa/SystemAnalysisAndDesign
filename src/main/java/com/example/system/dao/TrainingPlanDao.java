package com.example.system.dao;

import com.example.system.entity.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingPlanDao extends JpaRepository<TrainingPlan,Integer> {
}
