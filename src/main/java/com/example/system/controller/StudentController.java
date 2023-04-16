package com.example.system.controller;

import com.example.system.dao.RegisterTableDao;
import com.example.system.entity.RegisterTable;
import com.example.system.entity.Student;
import com.example.system.entity.User;
import com.example.system.model.Result;
import com.example.system.request.StuAndUser;
import com.example.system.response.RegisterTableResponse;
import com.example.system.service.StudentService;
import com.example.system.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    RegisterTableDao registerTableDao;
    @Autowired
    StudentService studentService;
    @PostMapping(value = "/sign/in")
    public Result studentSignIn(@RequestBody StuAndUser stuAndUser){
        return studentService.stuSignIn(stuAndUser);
    }
    @PostMapping(value = "/get/my")
    public Result studentGetMyReg(){
        List<RegisterTable> registerTables = registerTableDao.findAll();
        List<RegisterTableResponse> registerTableRses = new ArrayList<>();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Student student = user.getStudent();
        for (RegisterTable registerTable : registerTables) {
            if(registerTable.getStudent().getId()== student.getId()){
                RegisterTableResponse registerTableResponse = new RegisterTableResponse();
                registerTableResponse.setRegisterSuccess(registerTable.isRegisterSuccess());
                registerTableResponse.setStudentName(registerTable.getStudent().getName());
                registerTableResponse.setTrainingPlanName(registerTable.getTrainingPlan().getCourseName());
                registerTableRses.add(registerTableResponse);
            }
        }
        return ResultUtil.success(registerTableRses);
    }
}
