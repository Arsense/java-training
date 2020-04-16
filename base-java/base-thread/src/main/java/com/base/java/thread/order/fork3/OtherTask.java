package com.base.java.thread.order.fork3;

import com.base.java.thread.order.domain.OtherInfo;

import java.util.concurrent.RecursiveTask;

/**
 * @author tangwei
 * @date 2020/4/16 18:24
 */
public class OtherTask extends RecursiveTask<OtherInfo> {
    @Override
    protected OtherInfo compute() {
        System.out.println("执行"+ this.getClass().getSimpleName() + "线程名字为:" + Thread.currentThread().getName());
        return new OtherInfo();
    }
}
