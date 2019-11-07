package com.baizhi.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect//注明该类为切面类
@Component//切面类创建的对象  交由Spring工厂来管理
@Order(0)
public class Myaop {
    @Before("execution(* com.baizhi.service..*.*(String,..))")//前置通知的注解
    public void aop(JoinPoint joinPoint) {

        System.out.println("我是运行在原始方法之前执行的额外功能类0000000000000");
        //获取原始方法对象
        Signature signature = joinPoint.getSignature();
        //输出原始方法名字
        System.out.println(signature.getName());
        //获取传入给原始方法的实际参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        //获取原始对象
        Object target = joinPoint.getTarget();
        //输出原始对象的类型
        System.out.println(target.getClass());
    }

    @After("execution(* com.baizhi.service..*.*(String,..))")   //前置通知的注解
    public void after(JoinPoint joinPoint) {
        System.out.println("我是运行在原始方法之后执行的额外功能");
        //获取原始方法对象
        Signature signature = joinPoint.getSignature();
        //输出原始方法名字
        System.out.println(signature.getName());
        //获取传入给原始方法的实际参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        //获取原始对象
        Object target = joinPoint.getTarget();
        //输出原始对象的类型
        System.out.println(target.getClass());
    }

    @Around("execution(*  com.baizhi.service..*.*(String,String))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("原始方法执行之前执行的额外功能");
        //原始方法的执行
        Object ret = proceedingJoinPoint.proceed();
        Signature signature = proceedingJoinPoint.getSignature();
        //获取原始方法对象的名字
        System.out.println(signature.getName());
        //获取所有的实际参数
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            System.out.println(arg);
        }
        //获取原始对象的类型
        Object o = proceedingJoinPoint.getTarget();
        System.out.println(o.getClass());
        System.out.println("原始方法执行之后执行的额外功能");
        return ret;
    }

    //异常通知
    @AfterThrowing("execution(*  com.baizhi.service..*.register(String,String))")
    public void myexception() {
        System.out.println("我是产生异常时执行的方法");
    }
}
