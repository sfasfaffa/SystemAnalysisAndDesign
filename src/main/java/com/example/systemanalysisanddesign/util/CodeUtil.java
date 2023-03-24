package com.example.systemanalysisanddesign.util;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * @ClassName CodeUtil
 * @Description 编码工具
 * @Author pengdengyun
 * @Updater
 * @Create 2022-05-06
 * @Update
 **/
public class CodeUtil {

    /**
     * 使用MD5算法的加密工具
     */
    public static String encodeByMd5(String string) {
        try {
            // 确定计算方法
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            Base64.Encoder base64Encoder = Base64.getEncoder();
            // 加密字符串
            return base64Encoder.encodeToString(md5.digest(string.getBytes("utf-8")));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }}
}
