package com.example.system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
/**
 * 引用了https://blog.csdn.net/StillTogether/article/details/81587627的开源代码
 */



/**
 * @ClassName ResultEnum
 * @Description 响应交互码模板
 * @Author pengdengyun
 * @Updater
 * @Create 2022-05-06
 * @Update
 **/
@Getter
@AllArgsConstructor
public enum ResultEnum {
    //这里是可以自己定义的，方便与前端交互即可
    UNKNOWN_ERROR(-1,"未知错误"),
    SUCCESS(10000,"成功"),
    NO_THAT(5,"目标不存在"),
    USER_NOT_EXIST(-1,"用户不存在"),
    USER_IS_EXISTS(2,"已存在"),
    DATA_IS_NULL(3,"数据为空"),
    NOT_FOUND(6,"未查询到目标"),
    DATE_ERROR(-2,"传入数据错误"),
    PASSWORD_IS_WRONG(4,"密码错误"),
    NORIGHT(7,"无权进行");

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;
/*
    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

 */
}