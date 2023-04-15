package com.example.system.controller;

import com.example.system.model.Result;
import com.example.system.request.LecturerRequest;
import com.example.system.service.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lecture")
public class LecturerController {
    @Autowired
    LecturerService lecturerService;
    @PostMapping(value = "/create")
    public Result create(@RequestBody LecturerRequest lecturerRequest){
        return lecturerService.create(lecturerRequest);
    }
    @PostMapping(value = "/select/all")
    public Result selectAll(){
        return lecturerService.selectAll();
    }
    @PostMapping(value = "/delete")
    public Result delete(@RequestBody LecturerRequest lecturerRequest){
        return lecturerService.delete(lecturerRequest);
    }
    @PostMapping(value = "modify")
    public Result modify(@RequestBody LecturerRequest lecturerRequest){
        return lecturerService.modify(lecturerRequest);
    }
}
