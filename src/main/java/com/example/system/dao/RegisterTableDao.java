package com.example.system.dao;

import com.example.system.entity.RegisterTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterTableDao extends JpaRepository<RegisterTable,Integer> {
}
