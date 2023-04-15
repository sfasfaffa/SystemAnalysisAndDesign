package com.example.system.service;

import com.example.system.dao.EmailDao;
import com.example.system.dao.RegisterTableDao;
import com.example.system.dao.TrainingPlanDao;
import com.example.system.entity.*;
import com.example.system.model.Result;
import com.example.system.request.RegisterTableRequest;
import com.example.system.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class RegisterTableService {
    @Autowired
    RegisterTableDao registerTableDao;
    @Autowired
    TrainingPlanDao trainingPlanDao;
    @Autowired
    EmailDao emailDao;
    public Result createRegister(RegisterTableRequest registerTableRequest){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        RegisterTable registerTable = new RegisterTable();
        registerTable.setCompanyName(registerTableRequest.getCompanyName());
        registerTable.setPhone(registerTableRequest.getPhone());
        registerTable.setPost(registerTableRequest.getPost());
        registerTable.setStudent(user.getStudent());
        registerTable.setTechnicalLevel(registerTableRequest.getTechnicalLevel());
        registerTable.setTrainingPlan(trainingPlanDao.getById(registerTableRequest.getTrainingPlanId()));
        return ResultUtil.success("注册成功");
    }
    public Result getRegisterTable(){
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        Executor executor = user.getExecutor();
        List<TrainingPlan> trainingPlans = trainingPlanDao.getAllByExecutor(executor);
        List<RegisterTable> registerTables = new ArrayList<>();
        for (TrainingPlan trainingPlan : trainingPlans) {
            registerTables.addAll(registerTableDao.getAllByTrainingPlan(trainingPlan));
        }
        return ResultUtil.success(registerTables);
    }
    public Result permit(RegisterTableRequest registerTableRequest){
        RegisterTable registerTable = registerTableDao.getOne(registerTableRequest.getId());
        registerTable.setRegisterSuccess(registerTableRequest.isRegisterSuccess());
        Email email = new Email();
        email.setRecipientAddress(registerTableRequest.getPost());
        email.setTheme("课程报名结果通知");
        TrainingPlan trainingPlan = trainingPlanDao.getById(registerTableRequest.getId());
        if (registerTableRequest.isRegisterSuccess()){
            email.setMainBody("您对课程"+trainingPlan.getCourseName()+"的报名成功了，我们希望您能在接下来的学习过程中与我们一起成长，请登录网站查看课程的详细信息");
        }else {
            email.setMainBody("我们很遗憾的通知您，您对课程"+trainingPlan.getCourseName()+"的报名未成功，原因是"+registerTableRequest.getCause()+"，请您在满足条件后再进行报名，我们期待与您再次相见" );
        }
        return ResultUtil.success();
    }
}