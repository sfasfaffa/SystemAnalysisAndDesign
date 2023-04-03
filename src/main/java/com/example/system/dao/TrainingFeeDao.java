package com.example.system.dao;

import com.example.system.entity.TrainingFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingFeeDao extends JpaRepository<TrainingFee,Integer> {
}
