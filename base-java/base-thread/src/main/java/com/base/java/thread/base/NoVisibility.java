package com.base.java.thread.base;

/**
 * 主要是yield的考查
 *
 * @author Clay
 * @date 2018/12/14 17:42
 */
public class NoVisibility {
    private static boolean ready = false;
    private static int number;
    /**
     * @author Clay
     * @date 2018/12/14 17:43
     */
    public static class ReaderThread extends Thread{

        @Override
        public void run() {
            while (!ready)
                Thread.yield();
            System.out.println("number is:" + number);
        }

        public static void main(String[] args) {
            new ReaderThread().start();
            number = 42;
            ready = true;
        }
    }

}
