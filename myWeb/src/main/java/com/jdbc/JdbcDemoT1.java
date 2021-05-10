package com.jdbc;

import com.utlis.DruidUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcDemoT1 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
        String sql="update users set email = ? where  userid = ?";
        int count = template.update(sql, "23132132", 4);
        System.out.println(count);
    }
}
