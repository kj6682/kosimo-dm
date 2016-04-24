package org.kj6682.kosimo.dm;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by luigi on 24.04.16.
 */
@Aspect
@Component
public class FeatureAspect {

    @Around("execution(* AccountController.*(..))")
    public Object logServiceAccess(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(">>> Before: " + joinPoint + "<<<");
        try {
            System.out.println(">>> Annotation : " + extractFeature(joinPoint).value());
            return joinPoint.proceed();


        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            throw iae;
        }
    }

    private Feature extractFeature(ProceedingJoinPoint joinPoint) throws Throwable {
        return extractMethod(joinPoint).getAnnotation(Feature.class);
    }

    private Method extractMethod(ProceedingJoinPoint joinPoint) throws NoSuchMethodException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> targetClass = joinPoint.getTarget().getClass();
        return targetClass.getMethod(signature.getName(), signature.getParameterTypes());

    }

}

