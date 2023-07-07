package com.example.system.controller;

import com.example.system.dao.AAEDao;
import com.example.system.dao.RegisterTableDao;
import com.example.system.entity.AnswerAndEvaluation;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    AAEDao aaeDao;
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
    @PostMapping(value = "/get/my/id")//获取当前用户的id
    public Result getMyId() {
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return ResultUtil.success(user.getId());
    }
    @PostMapping(value = "/store/my/answer")//存储我的问题及回答，评估
    public Result storeMy(@RequestParam("Id")Integer id,//用户id
                          @RequestParam("s1")Integer s1,
                          @RequestParam("s2")Integer s2,
                          @RequestParam("s3")Integer s3,
                          @RequestParam("s4")Integer s4,
                          @RequestParam("s5")Integer s5){
        AnswerAndEvaluation answerAndEvaluation = new AnswerAndEvaluation();
        answerAndEvaluation.setS1(s1);
        answerAndEvaluation.setS2(s2);
        answerAndEvaluation.setS3(s3);
        answerAndEvaluation.setS4(s4);
        answerAndEvaluation.setS5(s5);
        answerAndEvaluation.setUid(id);
        aaeDao.save(answerAndEvaluation);
        return ResultUtil.success();
    }
    @PostMapping(value = "/get/my/answer")//获取我的所有历史问题及回答，评估
    public Result getMyAnswer(){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        return ResultUtil.success(aaeDao.getAllByUid(user.getId()));
    }
    @PostMapping(value = "/get/detail/answer")//根据历史回答的id获取具体信息
    public Result getDetailAnswer(@RequestParam("Id")Integer id){
        return ResultUtil.success(aaeDao.getById(id));
    }
}
