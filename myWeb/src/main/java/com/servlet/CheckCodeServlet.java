package com.servlet;

import com.utlis.CreateVerificationCode;
import com.utlis.CreateVerificationCodeImage;

import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CheckCodeServlet", value = "/CheckCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vericode= CreateVerificationCode.getSecurityCode();
        HttpSession session=req.getSession();
        session.setAttribute("verityCode",vericode);
        //设置返回的内容
        resp.setContentType("img/jpeg");
        //浏览器不缓存响应内容--验证码图片，点一次就要刷新一次，所以不能有缓存出现
        resp.setHeader("Pragma","No-cache");
        resp.setHeader("Cache-Control","no-cache");
        //设置验证码失效时间
        resp.setDateHeader("Expires",0);
        //以字节流发过去，交给img的src属性去解析即可
        ImageIO.write(new CreateVerificationCodeImage(vericode).createImage(),"JPEG",resp.getOutputStream());
    }
}
