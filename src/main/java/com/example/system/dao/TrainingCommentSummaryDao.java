package com.example.system.dao;

import com.example.system.entity.TrainingCommentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingCommentSummaryDao extends JpaRepository<TrainingCommentSummary,Integer> {
}
