package com.example.system.controller;

import com.example.system.entity.RegisterTable;
import com.example.system.model.Result;
import com.example.system.request.RegisterTableRequest;
import com.example.system.request.TrainingCommentSummaryRequest;
import com.example.system.service.TrainingCommentSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trainingCommentSummary")
public class TrainingCommentSummaryController {
    @Autowired
    TrainingCommentSummaryService trainingCommentSummaryService;
    @PostMapping(value = "create")
    public Result create(@RequestBody TrainingCommentSummaryRequest trainingCommentSummaryRequest){
        return trainingCommentSummaryService.create(trainingCommentSummaryRequest);
    }
}
