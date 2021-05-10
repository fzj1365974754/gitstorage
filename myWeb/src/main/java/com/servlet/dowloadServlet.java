package com.servlet;

import com.utlis.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet(value="/dowloadServlet")
public class dowloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String files = req.getParameter("filename");
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/img/"+files);
        FileInputStream fis = new FileInputStream(path);
        //设置resp相应头
        String mime = context.getMimeType(files);
        resp.setHeader("content-type",mime);
        //防止中文乱码
        String agent = req.getHeader("user-agent");
        files = DownLoadUtils.getFileName(agent, files);
        resp.setHeader("content-disposition","attachment;filename="+files);
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len=0;
        while((len=fis.read(buff))!=-1){
            sos.write(buff,0,len);
        }
    }
}
