package com.code.life.online.tool.result;

import com.alibaba.fastjson.JSON;

import java.util.function.BiFunction;

/**
 * @author Clay
 * @date 2019/5/22 13:58
 */
public class ApiResultHelper {

//    BiFunction<T, U, R>
//    T U入参  R是返回值
    public <T,R> R doExcute(T param, Protocol protocol, BiFunction<Protocol, T, R> function) {
        R result = function.apply(protocol, param);
        System.out.println("执行结束, 结果是:" + JSON.toJSON(result));
        return result;
    }



}
