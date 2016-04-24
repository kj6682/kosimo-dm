package org.kj6682.kosimo.dm;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;

/**
 * Created by luigi on 24.04.16.
 */
@Aspect
@Component
public class FeatureAspect {

    @Around("execution(* AccountController.*(..))")
    public Object logServiceAccess(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println(">>> Before: " + joinPoint + "<<<");
        try {
            System.out.println(">>> Annotation : " + retrieveAnnotationFrom( joinPoint ).value());
            return joinPoint.proceed();
        }catch (IllegalArgumentException iae) {
            iae.printStackTrace();
            throw iae;
        }
    }

    private Feature retrieveAnnotationFrom(ProceedingJoinPoint joinPoint ) throws Throwable{
        return retrieveTargetMethodFrom( joinPoint ).getAnnotation( Feature.class );
    }

    private Method retrieveTargetMethodFrom(ProceedingJoinPoint joinPoint ) throws Throwable{
        Class targetClass = joinPoint.getTarget().getClass();
        return targetClass.getMethod( joinPoint.getSignature().getName(), retrieveArgTypesFrom( joinPoint ) );
    }

    private Class[] retrieveArgTypesFrom( ProceedingJoinPoint joinPoint ){
        Class[] argTypes = new Class[joinPoint.getArgs().length];
        for( int i=0; i<argTypes.length; i++ ){
            argTypes[i] = joinPoint.getArgs()[i].getClass();
        }
        return argTypes;
    }

}

