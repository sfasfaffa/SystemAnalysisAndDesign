package com.example.system.dao;

import com.example.system.entity.Executor;
import com.example.system.entity.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingPlanDao extends JpaRepository<TrainingPlan,Integer> {
    TrainingPlan getById(Integer id);
    List<TrainingPlan> getAllByExecutor(Executor executor);
}