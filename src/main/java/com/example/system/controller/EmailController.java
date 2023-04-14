package com.example.system.controller;


import com.example.system.entity.Email;
import com.example.system.request.EmailRequest;
import com.example.system.response.BaseResponse;
import com.example.system.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/createEmail")
    public BaseResponse<String> createEmail(@RequestBody EmailRequest emailRequest) {
        return emailService.createEmail(emailRequest);
    }
}
