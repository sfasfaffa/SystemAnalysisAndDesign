package com.example.system.service;

import com.example.system.dao.StudentDao;
import com.example.system.dao.UserDao;
import com.example.system.entity.Student;
import com.example.system.entity.User;
import com.example.system.model.Result;
import com.example.system.request.StuAndUser;
import com.example.system.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.system.util.CodeUtil.encodeByMd5;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;
    @Autowired
    UserDao userDao;
    public Result stuSignIn(StuAndUser stuAndUser){
        User user = new User();
        user.setName(stuAndUser.getName());
        user.setPerms("student");
        user.setPwd(encodeByMd5(stuAndUser.getPwd()+encodeByMd5(stuAndUser.getName())));
        Student student = new Student();
        student.setGender(stuAndUser.getGender());
        student.setName(stuAndUser.getStuName());
        student.setPost(stuAndUser.getPost());
        user.setStudent(student);
        studentDao.save(student);
        userDao.save(user);
        return ResultUtil.success();
    }
}
