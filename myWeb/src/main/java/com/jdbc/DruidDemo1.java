package com.jdbc;

import com.utlis.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo1 {
//    PreparedStatement pstmt=null;
//    Connection conn=null;
    public static void main(String[] args) {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn = DruidUtils.getConnection();
            String sql="insert into users (username,password,email) values(?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,"asd");
            pstmt.setString(2,"fffff");
            pstmt.setString(3,"54563");
            int count =pstmt.executeUpdate();
            System.out.println(count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DruidUtils.close(null,pstmt,conn);
        }


    }
}
