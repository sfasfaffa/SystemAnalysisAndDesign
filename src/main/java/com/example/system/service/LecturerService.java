package com.example.system.service;

import com.example.system.dao.LecturerDao;
import com.example.system.entity.Lecturer;
import com.example.system.model.Result;
import com.example.system.request.LecturerRequest;
import com.example.system.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LecturerService {
    @Autowired
    LecturerDao lecturerDao;
    public Result create(LecturerRequest lecturerRequest){
        Lecturer lecturer = new Lecturer();
        lecturer.setEmailAddress(lecturerRequest.getEmailAddress());
        lecturer.setName(lecturerRequest.getName());
        lecturer.setPhone(lecturerRequest.getPhone());
        lecturer.setPosition(lecturerRequest.getPosition());
        lecturer.setSpeciality(lecturerRequest.getSpeciality());
        lecturerDao.save(lecturer);
        return ResultUtil.success();
    }
    public Result selectAll(){
        List<Lecturer> lecturers = lecturerDao.findAll();
        return ResultUtil.success(lecturers);
    }
}
