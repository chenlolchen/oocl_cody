package com.oocl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
public class LogAspect {
    public void logBefore(){
        System.out.println("log before ...");
    }

    public void logAfter(){
        System.out.println("log after ...");
    }

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
