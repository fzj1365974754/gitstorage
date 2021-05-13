package com.dao;

import com.domain.Users;

import java.util.List;

public interface UserDao {
    public void update(Users user);

    public void insert(Users user);

    public void delete(int userid);

    public Users get(int userid);
    public Long getForValue(String column);

    public List<Users> getForList();
}
