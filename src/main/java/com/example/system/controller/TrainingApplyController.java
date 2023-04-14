package com.example.system.controller;

import com.example.system.entity.TrainingApply;
import com.example.system.model.Result;
import com.example.system.request.TrainingApplyRequest;
import com.example.system.response.BaseResponse;
import com.example.system.response.TrainingApplyResponse;
import com.example.system.service.TrainingApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trainingApply")
public class TrainingApplyController {
    @Autowired
    private TrainingApplyService trainingApplyService;

    @PostMapping("/createTrainingApply")
    private Result<String> createTrainingApply(@RequestBody TrainingApplyRequest trainingApplyRequest){
        return trainingApplyService.createTrainingApply(trainingApplyRequest);
    }

    @GetMapping("/getTrainingApplyList")
    private Result<List<TrainingApplyResponse>> getTrainingApplyList(){
        return trainingApplyService.getTrainingApplyList();
    }
}
