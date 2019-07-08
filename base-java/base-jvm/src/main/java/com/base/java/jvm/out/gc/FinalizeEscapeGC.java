package com.base.java.jvm.out.gc;

/**
 * 关于可达性GC的回收测试
 *
 * @author Clay
 * @date 2019/1/23 13:36
 */
public class FinalizeEscapeGC {

    //用与检查对象是否存活
    private static FinalizeEscapeGC SAVE_HOOK = null;

    private void aLive() {
        System.out.println("我仍然活着");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize 方法调用了 要被回收了");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
       SAVE_HOOK = new FinalizeEscapeGC();

       SAVE_HOOK = null;
       System.gc();
       //finalize执行优先级很低 暂停以等待
       Thread.sleep(500);
       if (SAVE_HOOK != null) {
           SAVE_HOOK.aLive();
       } else {
           System.out.println("no 我现在被回收了");
       }
        SAVE_HOOK = null;
        System.gc();

        //finalize执行优先级很低 暂停以等待
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.aLive();
        } else {
            System.out.println("no 我现在被回收了");
        }

    }
}
