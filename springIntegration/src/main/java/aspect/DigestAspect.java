package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import pojo.User;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by CHENCO7 on 8/10/2017.
 */
@Aspect
@Component
public class DigestAspect {
    private MessageDigest digest;

    public DigestAspect() {
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Around(value = "execution(* service.UserService.login(..))")
    public Object login(ProceedingJoinPoint point) {
        Object o = null;
        String name = (String) point.getArgs()[0];
        String password = (String) point.getArgs()[1];
        password = process(password);
        try {
            o = point.proceed(new Object[]{name, password});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }

    @Around(value = "execution(* service.UserService.register(..))")
    public Object register(ProceedingJoinPoint point){
        Object o = null;
        User user = (User) point.getArgs()[0];
        System.out.println("register");
        user.setPassword(process(user.getPassword()));
        try {
            o = point.proceed(new Object[]{user});
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return o;
    }

    private String process(String s) {
        String result = null;
        try {
            byte[] bs = digest.digest(s.getBytes("ISO-8859-1"));
            result = new String(bs, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}
