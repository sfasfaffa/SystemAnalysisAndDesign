package com.example.system.controller;

import com.example.system.model.Result;
import com.example.system.request.RegisterTableRequest;
import com.example.system.service.RegisterTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registerTable")
public class RegisterTableController {
    @Autowired
    RegisterTableService registerTableService;
    @PostMapping(value = "/create")
    public Result createRegisterTable(@RequestBody RegisterTableRequest registerTableRequest){
        return registerTableService.createRegister(registerTableRequest);
    }
    @PostMapping(value = "/get/my")
    public Result getMy(){
        return registerTableService.getRegisterTable();
    }
    @PostMapping(value = "/permit")
    public Result permit(@RequestBody RegisterTableRequest registerTableRequest){
        return registerTableService.permit(registerTableRequest);
    }
    @PostMapping(value = "/fee/payment")
    public Result feePayment(@RequestBody RegisterTableRequest registerTableRequest){
        return registerTableService.feePayment(registerTableRequest);
    }
}