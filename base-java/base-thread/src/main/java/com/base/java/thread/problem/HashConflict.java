package com.base.java.thread.problem;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author Clay
 * @date 2019/6/28 14:10
 */
public class HashConflict {


    public static void main(String[] args) throws InterruptedException {

        final HashMap<String, String> map  = new HashMap<>(2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(),"");
                        }
                    },"ftf" + i).start();
                }
            }
        },"ftf");
        thread.start();
        System.out.println("结束了" + map.toString());
        thread.join();
        ArrayBlockingQueue
    }



}
