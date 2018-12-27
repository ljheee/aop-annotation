package com.ljheee.spring5.aspect;

import com.ljheee.spring5.annotation.ResultCache;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * 日志切面
 */
@Aspect
//@Component
public class LogAspect {

    // 前置
    @Before("execution(* com.ljheee.spring5.dao.*.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        String targetClassName = joinPoint.getTarget().getClass().getSimpleName();
        String methodFullName = targetClassName + "." + methodName;

        System.out.println("methodFullName=" + methodFullName);
    }

    @Around("execution(* com.ljheee.spring5.dao.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getName();
        String targetClassName = joinPoint.getTarget().getClass().getSimpleName();
        String methodFullName = targetClassName + "." + methodName;

        System.out.println("before");
        Object result = joinPoint.proceed();

        System.out.println("result=" + result);
    }

}