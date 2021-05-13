package com.servlet.jdbc;

import com.domain.Users;
import com.utlis.DruidUtils;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcDemoT2 {
    private JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());
    @Test
    public void test1(){
        Users users = new Users();
        users.setUsername("apple");
        users.setUserid(6);
        users.setPassword("123");
        users.setEmail("123456");
        System.out.println(users.getUsername()+users.getPassword()+users.getEmail()+users.getUserid());
        String sql="update users set username=?,password=?,email=? where userid = ?";
        int count =template.update(sql,users.getUsername(),"2",users.getEmail(),6);

    }
    @Test
    public void test2(){
        String sql="insert into users values(null,?,?,?)";
        int count = template.update(sql, "1111", "22222", "3333");
        System.out.println(count);
    }
    @Test
    public void test3(){
        String sql="delete from users where userid=?";
        int count = template.update(sql, 5);
        System.out.println(count);
    }
    @Test
    public void test4(){
        String sql="select * from users where userid=?";
        //map长度只能读取一条数据
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
    }
    @Test
    public void test5(){
        String sql="select * from users ";
        List<Map<String, Object>> list = template.queryForList(sql);
        System.out.println(list.get(0).get("username"));
//        for (Map<String, Object> stringObjectMap : list) {
//            System.out.println(stringObjectMap);
//        }
    }
    @Test
    public void test6(){
        String sql="select * from users ";
        List<Users> list = template.query(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet rs, int i) throws SQLException {
                Users users = new Users();
                int userid = rs.getInt("userid");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                users.setUserid(userid);
                users.setEmail(email);
                users.setUsername(username);
                users.setPassword(password);
                return users;
            }
        });
        for (Users users : list) {
            System.out.println(users);
        }
    }
    @Test
    public void test7(){
        //封装为对象
        String sql="select * from users ";
        List<Users> list = template.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
        for (Users users : list) {
            System.out.println(users);
        }
    }
    @Test
    public void test8(){
        String sql="select count(userid) from users ";
        Long total = template.queryForObject(sql, Long.class);
        System.out.println(total);
    }
}
