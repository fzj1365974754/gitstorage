package com.servlet.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CookieTest", value = "/CookieTest")
public class CookieTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = req.getCookies();
        boolean flag=false;
        if(cookies!=null && cookies.length>0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)){
                    flag=true;
                    Date date=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy年mm月dd日 hh:mm:ss");
                    String str_date = sdf.format(date);
                    str_date=URLEncoder.encode(str_date,"utf-8");//无法识别空格需要编码
                    cookie.setValue(str_date);
                    cookie.setMaxAge(60*60*24*30);
                    resp.addCookie(cookie);
                    String value = cookie.getValue();
                    //url解码
                    value = URLDecoder.decode(value,"utf-8");
                    resp.getWriter().write("<h1>欢迎回来上次访问事件"+value+"</h1>");
                    break;
                }
            }
        }
        if(cookies==null || cookies.length==0||flag==false){
            Date date=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy年mm月dd日 hh:mm:ss");
            String str_date = sdf.format(date);
            str_date=URLEncoder.encode(str_date,"utf-8");//无法识别空格需要编码
            Cookie cookie = new Cookie("lastTime",str_date);
            cookie.setMaxAge(60*60*24*30);
            resp.addCookie(cookie);
            resp.getWriter().write("<h1>欢迎首次登录</h1>");
        }
    }
}
