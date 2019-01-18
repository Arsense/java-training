package com.base.java.thread.base.callable;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author tangwei
 * @date 2018/12/12 11:04
 */
public class CallableDemo {

    public static void main(String[] args) {
        //使用线程池
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //创建返回的Array
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10;i++) {
            results.add(executor.submit(new TaskWithResult(i)));
        }
        for(Future<String> fs : results){
            try {
                System.out.println(fs.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } finally {
                executor.shutdown();
            }
        }

    }
}
