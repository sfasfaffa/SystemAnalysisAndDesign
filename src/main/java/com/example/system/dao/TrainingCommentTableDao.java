package com.example.system.dao;

import com.example.system.entity.TrainingCommentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCommentTableDao extends JpaRepository<TrainingCommentTable,Integer> {
}
