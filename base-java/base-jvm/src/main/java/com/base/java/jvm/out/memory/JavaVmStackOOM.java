package com.base.java.jvm.out.memory;

/**
 * 测试多线程溢出  不要运行 计算机很容易卡死
 * @author Clay
 * @date 2019/1/23 10:31
 */
public class JavaVmStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVmStackOOM oom = new JavaVmStackOOM();
        oom.stackLeakByThread();
    }

}
