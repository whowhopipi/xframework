package com.xframework.boot.stat.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {

    /**
     * 主模块
     *
     * @return
     */
    String module();

    /**
     * 次要模块
     *
     * @return
     */
    String subModule() default "";

}
