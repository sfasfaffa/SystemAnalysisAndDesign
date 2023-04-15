package com.example.system.controller;

import com.example.system.model.Result;
import com.example.system.request.ExeAndUser;
import com.example.system.service.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/executor")
public class ExecutorController {
    @Autowired
    ExecutorService executorService;
    @PostMapping(value = "/register")
    public Result register(@RequestBody ExeAndUser exeAndUser){
        return executorService.register(exeAndUser);
    }
}
