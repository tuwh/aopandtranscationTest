package com.uncub.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试
@ContextConfiguration(locations={"classpath:application.xml"}) //加载配置文件
public class AopTest {
    @Autowired
    TargetClass targetClass;

    @Test
    public void testAop() throws Exception {
        System.out.println(targetClass.target());
    }

    @Test
    public void testTranscation(){
        targetClass.addUser();
    }
}