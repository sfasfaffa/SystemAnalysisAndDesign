package com.example.system.controller;


import com.example.system.model.Result;
import com.example.system.model.UsernameAndPassword;
import com.example.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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