package com.utlis;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import static java.lang.Class.forName;

public class JdbcUtils {
    private static String url;
    private  static String user;
    private  static String password;
    private static String driver;
    static{
        try {
            String path= JdbcUtils.class.getClassLoader().getResource("JDBC/jdbc.properties").getPath();
            Properties pro=new Properties();
            pro.load(new FileReader(path));
            url= pro.getProperty("url");
            user= pro.getProperty("user");
            password=pro.getProperty("password");
            driver=pro.getProperty("driver");
            System.out.println(driver);
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }
    public static  void close(ResultSet rs, Statement stmt, Connection conn){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
