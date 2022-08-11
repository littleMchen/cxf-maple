package com.cxf.cxfbatch.annotation;


import java.lang.annotation.*;

/**
 * @description: PersonConfiguration
 * @date: 2022/8/9 23:03
 * @author: cxf
 * @version: 1.0
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ConvertOrder {

    String order() default "";
}
