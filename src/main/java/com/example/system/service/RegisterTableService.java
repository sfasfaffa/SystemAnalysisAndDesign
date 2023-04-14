package com.example.system.service;

import com.example.system.dao.RegisterTableDao;
import com.example.system.dao.TrainingPlanDao;
import com.example.system.entity.Executor;
import com.example.system.entity.RegisterTable;
import com.example.system.entity.TrainingPlan;
import com.example.system.entity.User;
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

}