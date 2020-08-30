package com.meyou.ssss.common.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
*@Description:通过该注解来判断是否需要登录，才能继续访问
*@Author:yuan yulin
*@Date:2020/8/15
*/
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StuLoginToken {

    boolean require() default true;
}
