package com.base.java.thread.exercise.util;

import java.util.Random;

/**
 * @author tangwei
 * @date 2020/4/10 0:14
 */
public class Tools {
    private static final Random rnd = new Random();


    public static void randomPause(int maxPauseTime) {
        int sleepTime = rnd.nextInt(maxPauseTime);
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
