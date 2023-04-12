package com.example.system.service;

import com.example.system.dao.EmailDao;
import com.example.system.entity.Email;
import com.example.system.request.EmailRequest;
import com.example.system.response.BaseResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private EmailDao emailDao;

    public BaseResponse<String> createEmail(EmailRequest emailRequest) {
        Email email = Email.builder()
                .recipientAddress(emailRequest.getRecipientAddress())
                .appendix(emailRequest.getAppendix())
                .mainBody(emailRequest.getMainBody())
                .theme(emailRequest.getTheme())
                .build();
        emailDao.save(email);
        return new BaseResponse<>("新建邮件成功",true,"");
    }
}
