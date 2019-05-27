package com.base.java.thread.juctool;


import com.google.common.util.concurrent.RateLimiter;

/**
 *
 *
 * google的xianlo限流工具包
 * @author tangwei
 * @date 2019/5/23 10:36
 */
public class RateLimiterDemo {

    //限制每秒只能处理2个请求
    private static RateLimiter limiter = RateLimiter.create(2);

    public static void main(String[] args) {

        for (int i = 0;i < 50;i++) {
            limiter.acquire();
            new Thread(new TimeThread()).start();
        }


    }

}
