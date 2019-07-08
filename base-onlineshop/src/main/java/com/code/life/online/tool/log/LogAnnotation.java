package com.code.life.online.tool.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 标识要进行日志处理的注解
 * @author Clay
 * @date 2019/5/8 21:26
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface LogAnnotation {
}
