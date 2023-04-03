package com.example.systemanalysisanddesign.dao;



import com.example.systemanalysisanddesign.entity.User;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
//    @Query(nativeQuery = true,value = "select * from user where username =?")
//    User findByName(String username);
//    @Query(nativeQuery = true,value = "select * from user where perms !=? or perms is null")
//    List<User> findAllByPerms(String perms);
}
