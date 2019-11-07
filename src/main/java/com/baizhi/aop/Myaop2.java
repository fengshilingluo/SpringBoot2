package com.baizhi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect//注明该类为切面类
@Component//切面类创建的对象  交由Spring工厂来管理
@Order(-8)
public class Myaop2 {
    @Before("execution(* com.baizhi.service..*.register(String,..))")   //前置通知的注解
    public void before(JoinPoint joinPoint) {
        System.out.println("我是运行在原始方法之前执行的额外功能11111111111");
    }
}
