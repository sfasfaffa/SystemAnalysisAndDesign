package com.example.system.dao;

import com.example.system.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

@Repository
public interface EmailDao extends JpaRepository<Email,Integer> {
}
