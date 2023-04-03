package com.example.system.dao;

import com.example.system.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerDao extends JpaRepository<Lecturer, Integer> {
}
