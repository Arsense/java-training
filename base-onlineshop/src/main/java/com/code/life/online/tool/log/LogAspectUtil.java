package com.code.life.online.tool.log;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.UUID;

/**
 *  切面引入打日志  不用每个地方
 * @author tangwei
 * @date 2019/5/8 21:18
 */
@Aspect
public class LogAspectUtil {

    @Around("@annotation(com.code.life.online.tool.log.LogAnnotation)")
    public Object logPrint(ProceedingJoinPoint joinPoint){
        Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        Object result = null;
        try {
            MDC.put("mdc", UUID.randomUUID().toString().replaceAll("-", ""));
            logger.info("切面检测方法{}参数：{}", joinPoint.getSignature().getName(), JSON.toJSONString(joinPoint.getArgs()));
            result = joinPoint.proceed();
            logger.info("切面检测方法{}返回值：{}", joinPoint.getSignature().getName(), JSON.toJSONString(result));
        } catch (Throwable throwable) {
            logger.error("接口异常 e={}", throwable);
        } finally {
            MDC.clear();
        }
        return result;

    }

    @LogAnnotation
    public static void test(){
        System.out.println("test log ok!");
    }


    public static void main(String[] args) {
        test();
    }
}
