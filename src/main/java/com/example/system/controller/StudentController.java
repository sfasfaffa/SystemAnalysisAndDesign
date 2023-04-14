package com.example.system.controller;

import com.example.system.model.Result;
import com.example.system.request.StuAndUser;
import com.example.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping(value = "/sign/in")
    public Result studentSignIn(@RequestBody StuAndUser stuAndUser){
        return studentService.stuSignIn(stuAndUser);
    }
}
