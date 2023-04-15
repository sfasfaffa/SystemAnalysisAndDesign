package com.example.system.dao;


import com.example.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    @Query(nativeQuery = true,value = "select * from user where name =?")
    User findByName(String username);
    @Query(nativeQuery = true,value = "select * from user where perms !=? or perms is null")
    List<User> findAllByPerms(String perms);
}
