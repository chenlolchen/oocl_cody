package com.oocl.annotation;

/**
 * Created by CHENCO7 on 8/9/2017.
 */

import java.lang.annotation.*;

/**
 * Created by mingwei on 12/2/16.
 * 基本资料注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Profile {
    /**
     * ID
     *
     * @return
     */
    public int id() default -1;

    /**
     * 身高
     *
     * @return
     */
    public int height() default 0;

    /**
     * 籍贯
     *
     * @return
     */
    public String nativePlace() default "";
}
