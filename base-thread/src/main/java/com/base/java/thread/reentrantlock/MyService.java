package com.base.java.thread.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tangwei
 * @date 2018/12/28 10:46
 */
public class MyService {
      private Lock lock = new ReentrantLock();
      public void testMethod() {
          lock.lock();
          for (int i = 0;i < 5;i++) {
              System.out.println("ThreadName=" + Thread.currentThread().getName()
                            +(" " +  (i + 1)));
          }
          lock.unlock();
      }



}
