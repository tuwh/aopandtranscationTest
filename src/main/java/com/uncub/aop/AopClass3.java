package com.uncub.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(-1)
public class AopClass3 {

    @Pointcut("execution(* com.uncub.aop.TargetClass.target(..))")
    public void point(){}

    @Before("execution(* com.uncub.aop.TargetClass.target(..))")
    public void before(JoinPoint joinPoint){
        System.out.println("=====================before 方法调用！" + this.getClass().getSimpleName());
    }

    @Around("point()")
    public String around(ProceedingJoinPoint joinpoint) throws Throwable {
        System.out.println("========================around方法开始调用！" + this.getClass().getSimpleName());
        String str = (String) joinpoint.proceed();
        System.out.println("========================around方法结束调用！" + this.getClass().getSimpleName());
        return "123456";
    }

    @After("point()")
    public void after(JoinPoint joinPoint){
        System.out.println("===================after方法调用" + this.getClass().getSimpleName());
    }

    @AfterReturning("point()")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println("===================afterReturn方法调用" + this.getClass().getSimpleName());
//        throw new RuntimeException("测试");
    }

    @AfterThrowing("point()")
    public void afterThrow(JoinPoint joinPoint){
        System.out.println("===================afterThrow方法调用" + this.getClass().getSimpleName());
    }
}
