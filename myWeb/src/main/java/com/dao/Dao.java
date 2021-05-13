package com.dao;

import com.domain.Users;
import com.utlis.DruidUtils;
import com.utlis.ReflectionUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;


public class Dao<T> {
    private JdbcTemplate template=new JdbcTemplate(DruidUtils.getDataSource());
    private Class<T> clazz;
    //取得class对象名称
    public Dao() {
        clazz = ReflectionUtils.getSuperGenericType(this.getClass());
    }

    public void update(String sql, Object ...args){
        int flag = template.update(sql, args);
        if(flag<1){
            System.out.println("error");
        }
    }

    public T get(String sql, Object ...args){
        return template.queryForObject(sql,
                new BeanPropertyRowMapper<T>(clazz),
                args);
    }

    public List<T> getForList(String sql){
        List<T> list = template.query(sql, new BeanPropertyRowMapper<T>(clazz));
        return list;
    }

    public long getForValue(String sql,Object ...args){
        Long total = template.queryForObject(sql,args,Long.class);
        return total;
    }
}
