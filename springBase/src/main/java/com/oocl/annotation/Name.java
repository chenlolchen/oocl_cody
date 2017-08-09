package com.oocl.annotation;

/**
 * Created by CHENCO7 on 8/9/2017.
 */

import java.lang.annotation.*;

/**
 * Created by mingwei on 12/2/16.
 * <p/>
 * 姓名注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Name {
    String value() default "";
}
