package com.servlet;

import com.dao.UsersDao;
import com.domain.Users;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet(name="loginservlet",value="/loginServlet")
public class LoginServlet extends HttpServlet  {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password = req.getParameter("password");
        String checkcode = req.getParameter("checkcode");
        //封装USer对象
        Users loginuser =new Users();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
        HttpSession session = req.getSession();
        String verityCode = (String)session.getAttribute("verityCode");
        //删除验证码session中存储的
        session.removeAttribute(verityCode);
        //调用userdao的login方法
        UsersDao dao=new UsersDao();
        Users user = dao.login(loginuser);
        //忽略验证码大小写
        if(verityCode!=null && verityCode.equalsIgnoreCase(checkcode)) {
            //判断user
            if (user == null) {
                req.getRequestDispatcher("/failServlet").forward(req, resp);
            } else {
                req.setAttribute("user", user);
                req.getRequestDispatcher("/successServlet").forward(req, resp);
            }
        }else{
            req.setAttribute("cc_error","验证码错误");
            req.getRequestDispatcher("/").forward(req,resp);
        }
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }


}
