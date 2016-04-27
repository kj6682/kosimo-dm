package org.kj6682.kosimo.dm;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by luigi on 24.04.16.
 */
@Aspect
@Component
class FeatureAspect {

    @Autowired
    FeatureConfig featureConfig;


    @Around("execution(* AccountController.*(..))")
    public Object checkFeature(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            System.out.println(">>>>>>>>>>>>>>>>>" + joinPoint.getSignature());
            if(featureConfig.check(extractFeature(joinPoint).value()))
                return joinPoint.proceed();

            throw new UnsupportedOperationException("This feature is not yet implemented.");

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

