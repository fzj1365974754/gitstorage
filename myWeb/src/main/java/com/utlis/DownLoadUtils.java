package com.utlis;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DownLoadUtils {
    //防止文件下载中文错误
    public  static String getFileName(String agent,String filename) throws UnsupportedEncodingException {
        if(agent.contains("MISE")){
            //IE
            filename = URLEncoder.encode(filename,"utf-8");
            filename = filename.replace("+"," ");
        }else if(agent.contains("Firefox")){
            BASE64Encoder base64Encoder=new BASE64Encoder();
            filename="=?utf-8?B?"+base64Encoder.encode(filename.getBytes("UTF-8"))+"?=";
        }else{
            filename=URLEncoder.encode(filename,"utf-8");
        }
        return filename;
    }
}
