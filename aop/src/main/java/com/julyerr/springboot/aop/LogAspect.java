package com.julyerr.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    final static Logger logger = LoggerFactory.getLogger(LogAspect.class);
    ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    //   如果使用的情况很多的话，直接在使用的时候就添加进来，方便在函数多个时候获取
//    @Pointcut("@annotation(action)")
//    public void statics(Action action) {
//
//    }
//
//    @Before("statics(action)")
//    public void doBefore(JoinPoint joinPoint, Action action) {
//        threadLocal.set(System.currentTimeMillis());
//        logger.info("note:{}", action.value());
//    }
//
//    @AfterReturning(value = "statics(action)", returning = "retValue")
//    public void doAfter(JoinPoint joinPoint, Action action, Object retValue) {
//        logger.info("note:{},cost time:{},ret:{}", action.value(), threadLocal.get(), retValue);
//    }

    //    如果使用到的注入的对象不是很多情况
    @Pointcut("@annotation(com.julyerr.springboot.aop.Action)")
    public void statics() {
    }

    @Before("statics()")
    public void doBefore(JoinPoint joinPoint) {
//        记录请求来的时间
        threadLocal.set(System.currentTimeMillis());
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        logger.info("note:{}", action.value());
    }

    @AfterReturning(pointcut = "statics()", returning = "retValue")
    public void doAfter(JoinPoint joinPoint, Object retValue) {
        //        记录请求结束的时间
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        logger.info("note:{},content:{},cost times:{}", action.value(), retValue, System.currentTimeMillis() - threadLocal.get());
    }
}
