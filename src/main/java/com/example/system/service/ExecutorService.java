package com.example.system.service;

import com.example.system.dao.ExecutorDao;
import com.example.system.dao.UserDao;
import com.example.system.entity.Executor;
import com.example.system.entity.User;
import com.example.system.model.Result;
import com.example.system.request.ExeAndUser;
import com.example.system.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.system.util.CodeUtil.encodeByMd5;

@Service
public class ExecutorService {
    @Autowired
    ExecutorDao executorDao;
    @Autowired
    UserDao userDao;
    public Result register(ExeAndUser exeAndUser){
        User user = new User();
        user.setPerms(exeAndUser.getPerms());
        user.setPwd(encodeByMd5(exeAndUser.getPwd()+encodeByMd5(exeAndUser.getName())));
        user.setName(exeAndUser.getName());
        Executor executor = new Executor();
        executor.setName(exeAndUser.getExName());
        user.setExecutor(executor);
        executorDao.save(executor);
        userDao.save(user);
        return ResultUtil.success();
    }
}
