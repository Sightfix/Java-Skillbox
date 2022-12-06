package com.zaurtregulov.spring.mvc_hibernate_aop.entity.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.zaurtregulov.spring.mvc_hibernate_aop.entity.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(
            ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
            MethodSignature methodSignature =
                    (MethodSignature) proceedingJoinPoint.getSignature();
            String methodfName = methodSignature.getName();

            System.out.println("Begin of " + methodfName);

            Object targetMethodResult = proceedingJoinPoint.proceed();

            System.out.println("End of " + methodfName);

            return targetMethodResult;
        }
    }
