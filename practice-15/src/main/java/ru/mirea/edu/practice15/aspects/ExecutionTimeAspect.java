package ru.mirea.edu.practice15.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import ru.mirea.edu.practice15.controller.ProductController;

@Aspect
@Component
public class ExecutionTimeAspect {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Pointcut("execution(* ru.mirea.edu.practice15.service..*(..))")
    public void stringProcessingMethods() {
    }

    @Around("stringProcessingMethods()")
    public Object calculateExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();

        Object result = joinPoint.proceed();

        long finish = System.nanoTime();

        logger.info("{} execution took {} ms", joinPoint.getSignature().getName(), (finish - start) / 1000000);

        return result;
    }
}
