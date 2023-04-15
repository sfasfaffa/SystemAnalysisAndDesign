package com.example.system;

import com.alibaba.fastjson.JSONObject;
import com.example.system.entity.Lecturer;
import com.example.system.request.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

import static java.lang.Math.max;


@SpringBootApplication
public class SystemAnalysisAndDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemAnalysisAndDesignApplication.class, args);
    }
}
