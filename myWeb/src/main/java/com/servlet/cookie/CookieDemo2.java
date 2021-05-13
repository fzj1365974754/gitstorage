package com.servlet.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieDemo2", value = "/CookieDemo2")
public class CookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cs = req.getCookies();
        //获取数据，遍历CS；
        if(cs!=null){
            for (Cookie c : cs) {
                String name=c.getName();
                String value = c.getValue();
                System.out.println(name+":"+value);
            }
        }
    }
}
