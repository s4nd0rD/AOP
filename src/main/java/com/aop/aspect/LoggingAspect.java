package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.aop.service.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Calling method: " + joinPoint.getSignature().getName());
        logger.info("With arguments: " + Arrays.toString(joinPoint.getArgs()));
    }


    @AfterReturning(pointcut = "execution(* com.aop.service.*.*(..))", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        logger.info("Method " + joinPoint.getSignature().getName() + " returned: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.aop.service.*.*(..))", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable exception) {
        logger.error("Exception thrown by method: " + joinPoint.getSignature().getName());
        logger.error("Exception message: " + exception.getMessage());
    }
}