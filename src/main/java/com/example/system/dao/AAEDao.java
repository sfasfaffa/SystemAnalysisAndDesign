package com.example.system.dao;

import com.example.system.entity.AnswerAndEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AAEDao extends JpaRepository<AnswerAndEvaluation, Integer> {
    List<AnswerAndEvaluation> getAllByUid(Integer uid);
    AnswerAndEvaluation getById(Integer id);
}
