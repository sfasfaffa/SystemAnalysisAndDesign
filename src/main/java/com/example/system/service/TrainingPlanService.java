package com.example.system.service;

import com.example.system.dao.LecturerDao;
import com.example.system.dao.TrainingContentDao;
import com.example.system.dao.TrainingFeeDao;
import com.example.system.dao.TrainingPlanDao;
import com.example.system.entity.TrainingContent;
import com.example.system.entity.TrainingFee;
import com.example.system.entity.TrainingPlan;
import com.example.system.model.Result;
import com.example.system.model.ResultEnum;
import com.example.system.request.TrainingPlanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingPlanService {
    @Autowired
    private TrainingPlanDao trainingPlanDao;
    @Autowired
    private TrainingContentDao trainingContentDao;
    @Autowired
    private TrainingFeeDao trainingFeeDao;
    @Autowired
    private LecturerDao lecturerDao;

    public Result<String> createTrainingPlan(TrainingPlanRequest trainingPlanRequest) {
        TrainingPlan trainingPlan = TrainingPlan
                .builder()
                .courseName(trainingPlanRequest.getCourseName())
                .trainingNum(trainingPlanRequest.getTrainingNum())
                .startTime(trainingPlanRequest.getStartTime())
                .endTime(trainingPlanRequest.getEndTime())
                .trainingPlace(trainingPlanRequest.getTrainingPlace())
                .lecturer(lecturerDao.findById(trainingPlanRequest.getLecturerId()).isPresent()?lecturerDao.findById(trainingPlanRequest.getLecturerId()).get():null)
                .build();
        TrainingContent trainingContent = TrainingContent
                .builder()
                .skillStack(trainingPlanRequest.getSkillStack())
                .trainingGoal(trainingPlanRequest.getTrainingGoal())
                .comment(trainingPlanRequest.getTrainingContentComment())
                .trainingPlan(trainingPlan)
                .build();
        TrainingFee trainingFee = TrainingFee
                .builder()
                .unitFee(trainingPlanRequest.getUnitFee())
                .totalFee(trainingPlanRequest.getTotalFee())
                .comment(trainingPlanRequest.getTrainingFeeComment())
                .trainingPlan(trainingPlan)
                .build();
        trainingPlanDao.save(trainingPlan);
        trainingContentDao.save(trainingContent);
        trainingPlan.setTrainingContent(trainingContent);
        trainingPlan.setTrainingFee(trainingFee);
        trainingFeeDao.save(trainingFee);
        return new Result<>(ResultEnum.SUCCESS.getCode(), "创建培训计划成功","");
    }

    public Result<List<TrainingPlan>> getTrainingPlanList() {
        List<TrainingPlan> trainingPlanList = trainingPlanDao.findAll();
        return new Result<>(ResultEnum.SUCCESS.getCode(), "获取培训计划列表成功",trainingPlanList);
    }


    public Result<String> updateTrainingPlan(TrainingPlanRequest trainingPlanRequest) {
        TrainingPlan trainingPlan = trainingPlanDao.getById(trainingPlanRequest.getId());
        TrainingContent trainingContent = trainingPlan.getTrainingContent();
        TrainingFee trainingFee = trainingPlan.getTrainingFee();
        trainingPlan.setCourseName(trainingPlanRequest.getCourseName());
        trainingPlan.setTrainingNum(trainingPlanRequest.getTrainingNum());
        trainingPlan.setStartTime(trainingPlanRequest.getStartTime());
        trainingPlan.setEndTime(trainingPlanRequest.getEndTime());
        trainingPlan.setTrainingPlace(trainingPlanRequest.getTrainingPlace());
        trainingPlan.setLecturer(lecturerDao.findById(trainingPlanRequest.getId()).isPresent()?lecturerDao.findById(trainingPlanRequest.getId()).get():null);

        trainingContent.setSkillStack(trainingPlanRequest.getSkillStack());
        trainingContent.setTrainingGoal(trainingPlanRequest.getTrainingGoal());
        trainingContent.setComment(trainingPlanRequest.getTrainingContentComment());

        trainingFee.setUnitFee(trainingPlanRequest.getUnitFee());
        trainingFee.setTotalFee(trainingPlanRequest.getTotalFee());
        trainingFee.setComment(trainingPlanRequest.getTrainingFeeComment());

        trainingPlanDao.save(trainingPlan);
        trainingContentDao.save(trainingContent);
        trainingFeeDao.save(trainingFee);
        return new Result<>(ResultEnum.SUCCESS.getCode(),"修改成功","");
    }

    public Result<String> deleteTrainingPlan(Integer trainingPlanId) {
        trainingPlanDao.findById(trainingPlanId);
        if(trainingPlanDao==null){
            return new Result<>(ResultEnum.NOT_FOUND.getCode(), "培训计划不存在","");
        }
        else {
            trainingPlanDao.deleteById(trainingPlanId);
            return new Result<>(ResultEnum.SUCCESS.getCode(), "删除成功","");
        }
    }
}
