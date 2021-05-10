package com.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieDemo1", value = "/CookieDemo1")
public class CookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Cookie对象
        Cookie c=new Cookie("msg","hello");
        //持久化到硬盘30S
        c.setMaxAge(30);
        //Cookie共享范围
//        c.setPath("/"); c.setPath("/myWeb");第二种只在本项目范围内共享
        //不同服务器之间Cookie共享
//        c.setDomain(".baidu.com");那么贴吧和百度cookie共享

        //发送Cookie
        resp.addCookie(c);
    }
}
