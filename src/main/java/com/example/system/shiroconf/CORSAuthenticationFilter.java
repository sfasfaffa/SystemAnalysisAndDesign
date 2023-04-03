package com.example.system.shiroconf;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用了开源代码：https://blog.csdn.net/weixin_38405253/article/details/90375043
 */
public class CORSAuthenticationFilter extends FormAuthenticationFilter {

    /**
     * 直接过滤可以访问的请求类型
     */
    private static final String REQUET_TYPE = "OPTIONS";


    public CORSAuthenticationFilter() {
        super();
    }


    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (((HttpServletRequest) request).getMethod().toUpperCase().equals(REQUET_TYPE)) {
            System.out.println("竟然成功了？");
            return true;
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse res = (HttpServletResponse)response;
        System.out.println("发生什么事了？");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setStatus(HttpServletResponse.SC_OK);
        res.setCharacterEncoding("UTF-8");
//        PrintWriter writer = res.getWriter();
//
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("msg","请先登录");
//        writer.write(String.valueOf(jsonObject));
//        writer.close();
        return false;
    }
}
