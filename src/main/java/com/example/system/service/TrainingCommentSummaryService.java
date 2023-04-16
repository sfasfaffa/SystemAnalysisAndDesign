package com.example.system.service;

import com.example.system.dao.TrainingCommentSummaryDao;
import com.example.system.dao.TrainingPlanDao;
import com.example.system.entity.TrainingCommentSummary;
import com.example.system.model.Result;
import com.example.system.request.TrainingCommentSummaryRequest;
import com.example.system.response.TrainingCommentSummaryResponse;
import com.example.system.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingCommentSummaryService {
    @Autowired
    TrainingCommentSummaryDao trainingCommentSummaryDao;
    @Autowired
    TrainingPlanDao trainingPlanDao;
    public Result create(TrainingCommentSummaryRequest trainingCommentSummaryRequest){
        TrainingCommentSummary trainingCommentSummary = new TrainingCommentSummary();
        trainingCommentSummary.setSatisfactionSummary(trainingCommentSummaryRequest.getSatisfactionSummary());
        trainingCommentSummary.setSuggestionCollect(trainingCommentSummaryRequest.getSuggestionCollect());
        trainingCommentSummaryDao.save(trainingCommentSummary);
        return ResultUtil.success();
    }

    public Result get() {
        List<TrainingCommentSummary> trainingCommentSummaries= trainingCommentSummaryDao.findAll();
        List<TrainingCommentSummaryResponse> trainingCommentSummaryResponses = new ArrayList<>();
        for(TrainingCommentSummary trainingCommentSummary:trainingCommentSummaries){
            TrainingCommentSummaryResponse response = TrainingCommentSummaryResponse
                    .builder()
                    .trainingPlanName(trainingCommentSummary.getTrainingPlan().getCourseName())
                    .satisfactionSummary(trainingCommentSummary.getSatisfactionSummary())
                    .suggestionCollect(trainingCommentSummary.getSuggestionCollect())
                    .build();
            trainingCommentSummaryResponses.add(response);
        }
        return ResultUtil.success(trainingCommentSummaryResponses);
    }
}
