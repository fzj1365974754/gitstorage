package com.serviceIml;

import com.dao.UseDao;
import com.domain.Users;
import com.service.UseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

//<bean id="useservice" class="com.serviceIml.UseServiceIml" p:useDao-ref="use"></bean>
@Service("useService")
public class UseServiceIml implements UseService {
    @Resource(name="useDao")
    private UseDao useDao;
    public UseServiceIml(UseDao useDao) {
        this.useDao = useDao;
    }

    public UseServiceIml() {
    }

    public void setUseDao(UseDao useDao) {
        this.useDao = useDao;
    }

    @Override
    public void save() {
        useDao.save();
    }
}
