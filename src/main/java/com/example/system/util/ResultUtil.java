package com.example.system.util;


/**
 * 引用了https://blog.csdn.net/StillTogether/article/details/81587627的开源代码
 */

import com.example.system.model.Result;
import com.example.system.model.ResultEnum;

/**
 * @ClassName ResultUtil
 * @Description 结果工具
 * @Author pengdengyun
 * @Updater
 * @Create 2022-05-06
 * @Update
 **/
public class ResultUtil {

    /**
     * 成功且带数据
     **/
    public static Result success(Object object) {
        Result result = new Result();
        result.setStatus(0);
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }
    public static Result success(Object object,String seconds) {
        Result result = new Result();
        result.setStatus(ResultEnum.SUCCESS.getCode());
        result.setMsg(seconds);
        result.setData(object);
        return result;
    }
    /**
     * 成功但不带数据
     **/
    public static Result success() {

        return success(null);
    }

    /**
     * 失败
     **/
    public static Result error( Integer code,String msg) {
        Result result = new Result();
        result.setStatus(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
    public static Result error( String msg,Object data) {
        Result result = new Result();
        result.setStatus(0);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    public static Result error( String msg) {
        Result result = new Result();
        result.setStatus(0);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
    /**
     * 未知错误
     **/
    public static Result unknown_Error() {
        Result result = new Result();
        result.setStatus(ResultEnum.UNKNOWN_ERROR.getCode());
        result.setMsg(ResultEnum.UNKNOWN_ERROR.getMsg());
        return result;
    }
}