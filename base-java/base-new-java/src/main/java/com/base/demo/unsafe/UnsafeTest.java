package com.base.demo.unsafe;

import sun.management.counter.Counter;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Clay
 * @date 2019/7/23 17:46
 */
public class UnsafeTest {


    private volatile int count = 0;

    private static long offset;
    private static Unsafe unsafe;
    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
            offset = unsafe.objectFieldOffset(Counter.class.getDeclaredField("count"));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void increment() {
        int before = count;
        // 失败了就重试直到成功为止
        while (!unsafe.compareAndSwapInt(this, offset, before, before + 1)) {
            before = count;
        }
    }

    public int getCount() {
        return count;
    }

}
