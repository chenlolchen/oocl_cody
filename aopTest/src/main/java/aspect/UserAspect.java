package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pojo.User;
import util.MD5Util;

/**
 * Created by CHENCO7 on 8/9/2017.
 */
@Aspect
@Component
public class UserAspect {

    @Around(value = "execution(* service..login(..))")
    public Object loginMD5(ProceedingJoinPoint point){
        System.out.println("in login .. ");
        Object o = null;
        try {
            String name = (String) point.getArgs()[0];
            String password = (String) point.getArgs()[1];
            password = MD5Util.getMD5(password);
            o = point.proceed(new Object[]{name, password});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }

    @Around(value = "execution(* service.UserService.register(..))")
    public Object registerMD5(ProceedingJoinPoint point){
        System.out.println("in register .. ");
        Object o = null;
        try {
            User user = (User) point.getArgs()[0];
            String password = user.getPassword();
            user.setPassword(MD5Util.getMD5(password));
            o = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }
}
