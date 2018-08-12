package com.uncub.aop;

import org.aopalliance.intercept.Invocation;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


public class AopClass2 {

    public void before(){
        System.out.println("=====================before 方法调用！" + this.getClass().getSimpleName());
    }

    public void around(ProceedingJoinPoint joinpoint) throws Throwable {
        System.out.println("========================around方法开始调用！" + this.getClass().getSimpleName());
        joinpoint.proceed();
        System.out.println("========================around方法结束调用！" + this.getClass().getSimpleName());
    }

    public void after(){
        System.out.println("===================after方法调用" + this.getClass().getSimpleName());
    }

    public void afterReturn(){
        System.out.println("===================afterReturn方法调用" + this.getClass().getSimpleName());
//        throw new RuntimeException("测试");
    }

    public void afterThrow(){
        System.out.println("===================afterThrow方法调用" + this.getClass().getSimpleName());
    }
}
