package com.base.java.thread.base.callable;

import java.util.concurrent.Callable;

/**
 * @author tangwei
 * @date 2018/12/12 11:03
 */
public class TaskWithResult implements Callable<String>{

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
