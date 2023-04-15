package com.example.system.service;

import com.example.system.dao.UserDao;
import com.example.system.entity.User;
import com.example.system.model.Result;
import com.example.system.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import static com.example.system.util.CodeUtil.encodeByMd5;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public Result userLogin(String password, String username) {
        password=encodeByMd5(password+encodeByMd5(username));
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);//执行登陆方法，如果没有异常就说明ok了.
            User user=userDao.findByName(username);
            System.out.println(user.getName().toString());
            Serializable tokenId = subject.getSession().getId();
            return ResultUtil.success(String.valueOf(tokenId),user.getPerms());
        }catch (UnknownAccountException e){//用户名不存在
            return ResultUtil.error(1,"用户不存在");
        }catch (IncorrectCredentialsException e){
            return ResultUtil.error(4,"密码错误");
        }
    }

    public Result userRegister(String password, String username,String perms) {
        password=encodeByMd5(password+encodeByMd5(username));
        if(userDao.findByName(username)==null){//确保用户名不重复
            User user=new User();
            user.setName(username);
            user.setPwd(password);
            user.setPerms(perms);
            userDao.save(user);
            return ResultUtil.success("注册成功");
        }else {
            return ResultUtil.error(2,"用户已存在");
        }
    }

    public Result userLogOut() {
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return ResultUtil.success("已退出登录");
    }
}
