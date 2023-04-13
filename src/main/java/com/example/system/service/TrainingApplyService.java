package com.example.system.service;

import com.example.system.dao.TrainingApplyDao;
import com.example.system.model.Result;
import com.example.system.request.TrainingApplyRequest;
import com.example.system.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingApplyService {
    @Autowired
    private TrainingApplyDao trainingApplyDao;

    public Result<String> createTrainingApply(TrainingApplyRequest trainingApplyRequest) {

        return null;
    }
}
