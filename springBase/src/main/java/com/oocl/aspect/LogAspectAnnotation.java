package com.oocl.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Component
@Aspect
public class LogAspectAnnotation {
    private final String pointcut = "execution(* com.oocl.service.WorkService.work(String))";

    @Before(value = pointcut)
    public void logBefore(){
        System.out.println("log before ...");
    }

    @After(value = pointcut)
    public void logAfter(){
        System.out.println("log after ...");
    }

    @Around(value = pointcut)
    public Object logAround(ProceedingJoinPoint point){
        Object o = null;
        System.out.println("log around before ..");
        try {
            // call target 可以动态修改
            String s = (String) point.getArgs()[0];
            System.out.println("s == " + s);
            o = point.proceed(new Object[]{s.toUpperCase()});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("log around after ..");
        return o;
    }
}
