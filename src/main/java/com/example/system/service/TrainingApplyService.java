package com.example.system.service;

import com.example.system.dao.TrainingApplyDao;
import com.example.system.dao.TrainingPlanDao;
import com.example.system.entity.TrainingApply;
import com.example.system.entity.TrainingPlan;
import com.example.system.model.Result;
import com.example.system.model.ResultEnum;
import com.example.system.request.TrainingApplyRequest;
import com.example.system.response.BaseResponse;
import com.example.system.response.TrainingApplyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainingApplyService {
    @Autowired
    private TrainingApplyDao trainingApplyDao;
    @Autowired
    private TrainingPlanDao trainingPlanDao;

    public Result<String> createTrainingApply(TrainingApplyRequest trainingApplyRequest) {
        TrainingApply trainingApply = TrainingApply.builder()
                .companyName(trainingApplyRequest.getCompanyName())
                .phone(trainingApplyRequest.getPhone())
                .trainingContentHope(trainingApplyRequest.getTrainingContentHope())
                .trainingTimeHope(trainingApplyRequest.getTrainingTimeHope())
                .trainingTarget(trainingApplyRequest.getTrainingTarget())
                .participantNum(trainingApplyRequest.getParticipantNum())
                .budget(trainingApplyRequest.getBudget())
                .comment(trainingApplyRequest.getComment())
                .build();
        trainingApplyDao.save(trainingApply);
        return new Result<>(ResultEnum.SUCCESS.getCode(),"培训申请已提交","");
    }

    public Result<List<TrainingApplyResponse>> getTrainingApplyList() {
        List<TrainingApply> trainingApplies = trainingApplyDao.findAll();
        List<TrainingApplyResponse> trainingApplyResponses = new ArrayList<>();
        for(TrainingApply trainingApply:trainingApplies){
            TrainingApplyResponse trainingApplyResponse = TrainingApplyResponse
                    .builder()
//                    .trainingPlanId(trainingApply.getTrainingPlan().getId())
                    .companyName(trainingApply.getCompanyName())
                    .phone(trainingApply.getPhone())
                    .trainingContentHope(trainingApply.getTrainingContentHope())
                    .trainingTimeHope(trainingApply.getTrainingTimeHope())
                    .trainingTarget(trainingApply.getTrainingTarget())
                    .participantNum(trainingApply.getParticipantNum())
                    .budget(trainingApply.getBudget())
                    .comment(trainingApply.getComment())
                    .build();
            trainingApplyResponses.add(trainingApplyResponse);
        }
        return new Result<>(
                ResultEnum.SUCCESS.getCode(),
                "获取培训申请列表成功",
                trainingApplyResponses
        );
    }
}
