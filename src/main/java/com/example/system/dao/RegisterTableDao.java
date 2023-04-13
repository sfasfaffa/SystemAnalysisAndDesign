package com.example.system.dao;

import com.example.system.entity.RegisterTable;
import com.example.system.entity.TrainingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterTableDao extends JpaRepository<RegisterTable,Integer> {
    List<RegisterTable> getAllByTrainingPlan(TrainingPlan trainingPlan);
}
