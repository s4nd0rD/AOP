package com.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {

    private final Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around("execution(* com.aop.service.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        var start = System.currentTimeMillis();

        var proceed = joinPoint.proceed();

        var executionTime = System.currentTimeMillis() - start;

        logger.info("{} executed in {}ms", joinPoint.getSignature(), executionTime);
        return proceed;
    }
}
