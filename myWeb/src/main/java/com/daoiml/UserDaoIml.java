package com.daoiml;

import com.dao.Dao;
import com.dao.UserDao;
import com.domain.Users;

import java.util.List;

public class UserDaoIml extends Dao<Users> implements UserDao {
    @Override
    public void update(Users user) {
        String sql = "update users set username=?,password=?,email=? where userid = ?";
        System.out.println(sql);
        update(sql,user.getUsername(), user.getPassword(), user.getEmail(),user.getUserid());
    }

    @Override
    public void insert(Users user) {
        String sql = "INSERT INTO users(username, password, email) VALUES(?, ?, ?)";
        update(sql, user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public void delete(int userid) {
        String sql = "delete from users where userid=?";
        update(sql, userid);
    }

    @Override
    public Users get(int userid) {
        String sql = "select * from users where userid=?";
        Users users = get(sql, userid);
        return users;
    }

    @Override
    public Long getForValue(String column){
        String sql="select count(*) from users group by ?";
        long num = getForValue(sql, column);
        return num;
    }

    @Override
    public List<Users> getForList() {
        String sql = "select * from users";
        List<Users> list = getForList(sql);
        return list;
    }
}
