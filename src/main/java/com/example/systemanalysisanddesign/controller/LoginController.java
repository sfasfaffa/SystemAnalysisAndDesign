package com.example.systemanalysisanddesign.controller;

import com.example.systemanalysisanddesign.dao.UserDao;
import com.example.systemanalysisanddesign.model.Result;
import com.example.systemanalysisanddesign.model.UsernameAndPassword;
import com.example.systemanalysisanddesign.service.UserService;
import com.example.systemanalysisanddesign.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login/normal/register")
    public Result register(@RequestBody UsernameAndPassword usernameAndPassword){
        return userService.userRegister(usernameAndPassword.getPassword(), usernameAndPassword.getUsername());
    }

    @PostMapping(value = "/login/normal/login")
    public Result login(@RequestBody UsernameAndPassword usernameAndPassword) {
        return userService.userLogin(usernameAndPassword.getPassword(), usernameAndPassword.getUsername());
    }

    @PostMapping("/logout")
    public Result logout(){return userService.userLogOut();}

}