package com.example.system.controller;

import com.example.system.entity.TrainingCommentTable;
import com.example.system.model.Result;
import com.example.system.request.TrainingCommentSummaryRequest;
import com.example.system.request.TrainingCommentTableRequest;
import com.example.system.service.TrainingCommentTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trainingCommentTable")
public class TrainingCommentTableController {
    @Autowired
    TrainingCommentTableService trainingCommentTableService;
    @PostMapping(value = "/create")
    public Result createComment(@RequestBody TrainingCommentTableRequest trainingCommentTableRequest){
        return trainingCommentTableService.create(trainingCommentTableRequest);
    }
    @PostMapping(value = "/delete")
    public Result delete(@RequestBody TrainingCommentTableRequest trainingCommentTableRequest){
        return trainingCommentTableService.delete(trainingCommentTableRequest);
    }
    @PostMapping(value = "/get/all")
    public Result getAll(){
        return trainingCommentTableService.getAll();
    }
}
