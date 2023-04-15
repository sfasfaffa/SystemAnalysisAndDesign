package com.example.system.service;

import com.example.system.dao.RegisterTableDao;
import com.example.system.dao.SignInTableDao;
import com.example.system.entity.SignInTable;
import com.example.system.model.Result;
import com.example.system.request.SignInTableRequest;
import com.example.system.response.SignInTableResponse;
import com.example.system.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignInTableService {
    @Autowired
    SignInTableDao signInTableDao;
    @Autowired
    RegisterTableDao registerTableDao;
    public Result getSignInTable(){
        List<SignInTable> signInTables = signInTableDao.findAll();
        List<SignInTableResponse> signInTableResponses = new ArrayList<>();
        for (SignInTable signInTable : signInTables) {
            SignInTableResponse signInTableResponse = new SignInTableResponse();
            signInTableResponse.setStudentName(signInTable.getStudent().getName());
            signInTableResponse.setTrainingPlanId(signInTable.getTrainingPlan().getId());
            signInTableResponse.setTrainingPlanName(signInTable.getTrainingPlan().getCourseName());
            signInTableResponse.setId(signInTable.getId());
            signInTableResponses.add(signInTableResponse);
        }
        return ResultUtil.success(signInTableResponses);
    }
    public Result modify(SignInTableRequest signInTableRequest){
        SignInTable signInTable = signInTableDao.getOne(signInTableRequest.getId());
        signInTable.setRegister(signInTableRequest.isRegister());
        signInTableDao.save(signInTable);
        return ResultUtil.success();
    }
}
