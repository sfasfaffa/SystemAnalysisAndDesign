package com.example.system.service;

import com.example.system.dao.TrainingCommentSummaryDao;
import com.example.system.entity.TrainingCommentSummary;
import com.example.system.model.Result;
import com.example.system.request.TrainingCommentSummaryRequest;
import com.example.system.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainingCommentSummaryService {
    @Autowired
    TrainingCommentSummaryDao trainingCommentSummaryDao;
    public Result create(TrainingCommentSummaryRequest trainingCommentSummaryRequest){
        TrainingCommentSummary trainingCommentSummary = new TrainingCommentSummary();
        trainingCommentSummary.setSatisfactionSummary(trainingCommentSummaryRequest.getSatisfactionSummary());
        trainingCommentSummary.setSuggestionCollect(trainingCommentSummaryRequest.getSuggestionCollect());
        trainingCommentSummaryDao.save(trainingCommentSummary);
        return ResultUtil.success();
    }
}
