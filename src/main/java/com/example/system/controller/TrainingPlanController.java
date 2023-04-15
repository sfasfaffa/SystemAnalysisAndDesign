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

//excutor需要修改
    @PostMapping("/create")
    public Result<String> createTrainingPlan(@RequestBody TrainingPlanRequest trainingPlanRequest){
        return trainingPlanService.createTrainingPlan(trainingPlanRequest);
    }

//需要新建返回类
    @GetMapping("/get")
    public Result<List<TrainingPlan>>getTrainingPlanList(){
        return trainingPlanService.getTrainingPlanList();
    }

    @GetMapping("/get/all")
    public Result<List<TrainingPlanResponse>>getAll(){
        return trainingPlanService.getAll();
    }

    @PostMapping("/update")
    public Result<String>updateTrainingPlan(@RequestBody TrainingPlanRequest trainingPlanRequest){
        return trainingPlanService.updateTrainingPlan(trainingPlanRequest);
    }

    @DeleteMapping("/delete")
    public Result<String>deleteTrainingPlan(@RequestBody TrainingPlanRequest trainingPlanRequest){
        return trainingPlanService.deleteTrainingPlan(trainingPlanRequest);
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
