package com.example.system.controller;

import com.example.system.model.Result;
import com.example.system.request.TrainingApplyRequest;
import com.example.system.response.BaseResponse;
import com.example.system.service.TrainingApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("trainingApply")
public class TrainingApplyController {
    @Autowired
    private TrainingApplyService trainingApplyService;

    @PostMapping("/createTrainingApply")
    private Result<String> createTrainingApply(TrainingApplyRequest trainingApplyRequest){
        return trainingApplyService.createTrainingApply(trainingApplyRequest);
    }
}
