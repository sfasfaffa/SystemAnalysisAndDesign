package com.example.system.service;

import com.example.system.dao.RegisterTableDao;
import com.example.system.dao.TrainingCommentTableDao;
import com.example.system.dao.TrainingPlanDao;
import com.example.system.entity.TrainingCommentTable;
import com.example.system.entity.User;
import com.example.system.model.Result;
import com.example.system.request.TrainingCommentTableRequest;
import com.example.system.response.TrainingCommentTableResponse;
import com.example.system.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingCommentTableService {
    @Autowired
    TrainingCommentTableDao trainingCommentTableDao;
    @Autowired
    TrainingPlanDao trainingPlanDao;
    @Autowired
    RegisterTableDao registerTableDao;
    public Result create(TrainingCommentTableRequest trainingCommentTableRequest){
        TrainingCommentTable trainingCommentTable = new TrainingCommentTable();
        if(trainingCommentTableRequest.getRegisterTable()!=null){
            trainingCommentTable.setRegisterTable(registerTableDao.getOne(trainingCommentTableRequest.getRegisterTable()));
        }
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
        List<TrainingCommentTable> trainingCommentTables = trainingCommentTableDao.findAll();
        List<TrainingCommentTableResponse> trainingCommentTableResponses = new ArrayList<>();
        for (TrainingCommentTable trainingCommentTable : trainingCommentTables) {
            TrainingCommentTableResponse trainingCommentTableResponse = new TrainingCommentTableResponse();
            trainingCommentTableResponse.setTrainingSatisfaction(trainingCommentTable.getTrainingSatisfaction());
            trainingCommentTableResponse.setSuggestions(trainingCommentTable.getSuggestions());
            trainingCommentTableResponse.setTrainingPlanName(trainingCommentTable.getRegisterTable().getTrainingPlan().getCourseName());
            trainingCommentTableResponse.setStuName(trainingCommentTable.getRegisterTable().getStudent().getName());
            trainingCommentTableResponses.add(trainingCommentTableResponse);
        }
        return ResultUtil.success(trainingCommentTableResponses);
    }
}