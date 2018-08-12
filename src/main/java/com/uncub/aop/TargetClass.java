package com.uncub.aop;

import com.uncub.dao.base.UserMapper;
import com.uncub.dto.base.User;
import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TargetClass {
    @Autowired
    UserMapper userMapper;

    public String target() {
        System.out.println("===================invoke target class");
        return "targetClass";
    }

    @Transactional("transactionManager")
    public void addUser(){
        User user = new User();
        user.setUserNo("testTranscaction");
        user.setPassword("123456");
        userMapper.insert(user);
//        User user1 = userMapper.selectUserById(1);
//        System.out.println(user1.getUserName());
//        throw new RuntimeException("test");
    }
}
