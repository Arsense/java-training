package com.base.java.thread.pool;

import java.util.concurrent.*;

/**
 * @author tangwei
 * @date 2019/4/28 19:33
 */
public class ThreadPoolExceptionDemo {

    public static void main(String[] args) {
        ExecutorService executorService = new TraceThreadPoolExecutor(5, Integer.MAX_VALUE,0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
            //execute 会报异常  submit不会 需要重写 100/0 是异常
            executorService.submit(new WrongTask(100,i));

        }
    }


    private static class WrongTask implements Runnable{
        int a, b;

        public WrongTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a / b;
            System.out.println(re);
        }

    }


    /**
     *
     *  重写submit
     */
    static class TraceThreadPoolExecutor extends ThreadPoolExecutor {

        public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                       TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        @Override
        public void execute(Runnable command) {
//      super.execute(command);
            super.execute(wrap(command, clientTrace(), Thread.currentThread().getName()));
        }

        @Override
        public Future<?> submit(Runnable task) {
//      return super.submit(task);
            return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
        }

        private Exception clientTrace() {
            return new Exception("Client stack trace");
        }


        private Runnable wrap(final Runnable task, final Exception clientStack,
                              String clientThreaName) {
            return new Runnable() {
                @Override
                public void run() {
                    try {
                        task.run();
                    } catch (Exception e) {
                        e.printStackTrace();
                        clientStack.printStackTrace();
                        throw e;
                    }
                }
            };
        }
    }

}
