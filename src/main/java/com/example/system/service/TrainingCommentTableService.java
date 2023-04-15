package com.example.system.service;

import com.example.system.dao.RegisterTableDao;
import com.example.system.dao.TrainingCommentTableDao;
import com.example.system.entity.TrainingCommentTable;
import com.example.system.entity.User;
import com.example.system.model.Result;
import com.example.system.request.TrainingCommentTableRequest;
import com.example.system.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingCommentTableService {
    @Autowired
    TrainingCommentTableDao trainingCommentTableDao;
    @Autowired
    RegisterTableDao registerTableDao;
    public Result create(TrainingCommentTableRequest trainingCommentTableRequest){
        TrainingCommentTable trainingCommentTable = new TrainingCommentTable();
        trainingCommentTable.setRegisterTable(registerTableDao.getOne(trainingCommentTableRequest.getRegisterTable()));
        trainingCommentTable.setSuggestions(trainingCommentTableRequest.getSuggestions());
        trainingCommentTable.setTrainingSatisfaction(trainingCommentTableRequest.getTrainingSatisfaction());
        trainingCommentTableDao.save(trainingCommentTable);
        return ResultUtil.success();
    }
    public Result delete(TrainingCommentTableRequest trainingCommentTableRequest){
        TrainingCommentTable trainingCommentTable = trainingCommentTableDao.getOne(trainingCommentTableRequest.getId());
        trainingCommentTableDao.delete(trainingCommentTable);
        return ResultUtil.success();
    }
    public Result getAll(){
        return ResultUtil.success(trainingCommentTableDao.findAll());
    }
}