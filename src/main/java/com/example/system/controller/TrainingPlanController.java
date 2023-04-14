package com.example.system.controller;

import com.example.system.dao.TrainingContentDao;
import com.example.system.dao.TrainingFeeDao;
import com.example.system.dao.TrainingPlanDao;
import com.example.system.entity.TrainingContent;
import com.example.system.entity.TrainingFee;
import com.example.system.entity.TrainingPlan;
import com.example.system.model.Result;
import com.example.system.request.TrainingPlanRequest;
import com.example.system.response.TrainingPlanResponse;
import com.example.system.service.TrainingPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("trainingPlan")
public class TrainingPlanController {
    @Autowired
    private TrainingPlanService trainingPlanService;

    @PostMapping("/createTrainingPlan")
    private Result<String> createTrainingPlan(@RequestBody TrainingPlanRequest trainingPlanRequest){
        return trainingPlanService.createTrainingPlan(trainingPlanRequest);
    }

    @GetMapping("/getTrainingPlanList")
    private Result<List<TrainingPlan>>getTrainingPlanList(){
        return trainingPlanService.getTrainingPlanList();
    }

    @PostMapping("/updateTrainingPlan")
    private Result<String>updateTrainingPlan(@RequestBody TrainingPlanRequest trainingPlanRequest){
        return trainingPlanService.updateTrainingPlan(trainingPlanRequest);
    }

    @DeleteMapping("/deleteTrainingPlan")
    private Result<String>deleteTrainingPlan(@RequestBody Integer trainingPlanId){
        return trainingPlanService.deleteTrainingPlan(trainingPlanId);
    }
}
