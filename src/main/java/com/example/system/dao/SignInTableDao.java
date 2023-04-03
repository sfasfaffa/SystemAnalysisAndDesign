package com.example.system.dao;

import com.example.system.entity.SignInTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignInTableDao extends JpaRepository<SignInTable,Integer> {
}
