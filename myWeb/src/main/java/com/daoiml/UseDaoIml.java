package com.daoiml;

import com.dao.UseDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//<bean id="use" class="com.daoiml.UseDaoIml" scope="singleton" >
@Repository("useDao")
public class UseDaoIml implements UseDao {
    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UseDaoIml() {
        System.out.println("usedao创建");
    }

//    public void init(){
//        System.out.println("初始化方法");
//    }
//    public void destroy(){
//        System.out.println("销毁方法");
//    }
    @Override
    public void save() {
        System.out.println(username+"========="+age);
        System.out.println("Save....");
    }
}
