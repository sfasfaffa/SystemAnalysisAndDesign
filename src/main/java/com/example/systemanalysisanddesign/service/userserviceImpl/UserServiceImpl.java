package com.example.systemanalysisanddesign.service.userserviceImpl;


import com.example.systemanalysisanddesign.dao.UserDao;
import com.example.systemanalysisanddesign.entity.User;
import com.example.systemanalysisanddesign.model.Result;
import com.example.systemanalysisanddesign.service.UserService;
import com.example.systemanalysisanddesign.util.ResultUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.systemanalysisanddesign.util.CodeUtil.encodeByMd5;


/**
 * @ClassName UserServiceImpl
 * @Description 有关用户的服务实现
 * @Author pengdengyun
 * @Updater
 * @Create 2022-05-06
 * @Update
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
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
            return ResultUtil.success(String.valueOf(tokenId));
        }catch (UnknownAccountException e){//用户名不存在
            return ResultUtil.error(1,"用户不存在");
        }catch (IncorrectCredentialsException e){
            return ResultUtil.error(4,"密码错误");
        }
    }
    @Override
    public Result userRegister(String password, String username) {
        password=encodeByMd5(password+encodeByMd5(username));
        if(userDao.findByName(username)==null){//确保用户名不重复
            User user=new User();
            user.setName(username);
            user.setPwd(password);
            userDao.save(user);
            return ResultUtil.success("注册成功");
        }else {
            return ResultUtil.error(2,"用户已存在");
        }
    }
    @Override
    public Result userLogOut() {
        Subject subject=SecurityUtils.getSubject();
        subject.logout();
        return ResultUtil.success("已退出登录");
    }



}
