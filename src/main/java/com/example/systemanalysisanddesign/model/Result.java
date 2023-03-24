package com.example.systemanalysisanddesign.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * 引用了https://blog.csdn.net/StillTogether/article/details/81587627的开源代码
 */


/**
 * @ClassName Result
 * @Description 响应结果模板
 * @Author pengdengyun
 * @Updater
 * @Create 2022-05-06
 * @Update
 **/
@Getter
@Setter
@AllArgsConstructor
public class Result<T> {
    /**
     * 响应码
     */
    private Integer code;

    /**
     * 信息
     */
    private String msg;

    /**
     * 数据封装
     */
    private T data;

    public Result() {
        super();
    }
/*
    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

 */
/*
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
*/
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}