package com.immoc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by chenzhangli01 on 2017/6/2.
 */
@Aspect      // 声明这是一个AOP
@Component   // 该注解可以将该组件引入到 Spring 容器中
public class HttpAspect {

//    @Before("execution(public  * com.immoc.controller.GirlController.girlList())")   // girlList()方法执行前就已经执行
//    public void log(){
//        System.out.println("111111111111");
//    }
//
//
//    @After("execution(public  * com.immoc.controller.GirlController.*(..))")   // GirlController中所有方法执行后执行
//    public void doAfter(){
//        System.out.println("222222222222");
//    }

    // 上述方式对于每个 execution 中 内容重复，可以改进如下：

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);  // Spring 自带的日志框架

    @Pointcut("execution(public  * com.immoc.controller.GirlController.*(..))")   // 定义一个函数说先明要切的点
    public void log(){

    }

    @Before("log()")   // girlList()方法执行前就已经执行
    public void doBefore(JoinPoint joinPoint){
        // System.out.println("111111111111");
        //log.info("11111111111111");  // log打印出来的信息更丰富

        // 以下需要打印一些更重要的信息———— 获取请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        logger.info("url = {}", request.getRequestURL());

        // method
        logger.info("ip = {}", request.getMethod());

        // ip
        logger.info("ip = {}", request.getRemoteAddr());

        // 类方法
        logger.info("class_method = {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName()); // 类名和类方法

        // 参数
        logger.info("args = {}", joinPoint.getArgs());

    }

    @AfterReturning(pointcut = "log()", returning = "object")   // GirlController中所有方法执行后执行
    public void doAfterReturning(Object object){
        logger.info("response={}", object.toString());
    }

    @After("log()")   // GirlController中所有方法执行后执行
    public void doAfter(){
        //System.out.println("222222222222");
        logger.info("222222222222222");
    }



}
