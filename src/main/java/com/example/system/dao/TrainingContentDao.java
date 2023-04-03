package com.example.system.dao;

import com.example.system.entity.TrainingContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingContentDao extends JpaRepository<TrainingContent,Integer> {
}
