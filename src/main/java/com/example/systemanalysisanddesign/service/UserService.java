package com.example.systemanalysisanddesign.service;

import com.example.systemanalysisanddesign.entity.User;
import com.example.systemanalysisanddesign.model.Result;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface UserService {
    Result userLogin(String password, String username);
    Result userRegister(String password,String username);
    Result userLogOut();
}
