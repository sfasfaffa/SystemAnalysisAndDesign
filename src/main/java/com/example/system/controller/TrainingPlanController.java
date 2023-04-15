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
@RequestMapping("/trainingPlan")
public class TrainingPlanController {
    @Autowired
    private TrainingPlanService trainingPlanService;


    @PostMapping("/create")
    public Result<String> createTrainingPlan(@RequestBody TrainingPlanRequest trainingPlanRequest){
        return trainingPlanService.createTrainingPlan(trainingPlanRequest);
    }


    @GetMapping("/get")
    public Result<List<TrainingPlan>>getTrainingPlanList(@RequestBody Integer executorId){
        return trainingPlanService.getTrainingPlanList(executorId);
    }


    @PostMapping("/update")
    public Result<String>updateTrainingPlan(@RequestBody TrainingPlanRequest trainingPlanRequest){
        return trainingPlanService.updateTrainingPlan(trainingPlanRequest);
    }


    @DeleteMapping("/delete")
    public Result<String>deleteTrainingPlan(@RequestBody Integer trainingPlanId){
        return trainingPlanService.deleteTrainingPlan(trainingPlanId);
    }
    
    @PostMapping(value = "/publish")
    public Result<String> publish(@RequestBody TrainingPlanRequest trainingPlanRequest){
        return trainingPlanService.publish(trainingPlanRequest);
    }

    @PostMapping(value = "/get/visible")
    public Result<List<TrainingPlan>> getVisible(){
        return trainingPlanService.getVisible();
    }

}
