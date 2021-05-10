package com.dao;

import com.domain.Users;
import com.utlis.DruidUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
//操作数据库中User表的类
public class UsersDao {
    //获取Template
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    //登陆方法返沪用户名和密码 return所有用数据
    public Users login(Users loginUser) {
        try {
            String sql="select * from users where username=? and password=?";
            //返回一行可以
            Users user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<Users>(Users.class),
                    loginUser.getUsername(),loginUser.getPassword());
            return user;
        } catch (DataAccessException e) {
//            e.printStackTrace();
            return null;
        }
    }
}
