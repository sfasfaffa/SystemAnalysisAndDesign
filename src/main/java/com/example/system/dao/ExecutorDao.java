package com.example.system.dao;

import com.example.system.entity.Executor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutorDao extends JpaRepository<Executor,Integer> {
}
