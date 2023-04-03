package com.example.system.dao;

import com.example.system.entity.TrainingApply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingApplyDao extends JpaRepository<TrainingApply,Integer> {
}
