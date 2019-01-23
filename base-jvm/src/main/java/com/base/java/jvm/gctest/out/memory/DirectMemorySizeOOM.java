package com.base.java.jvm.gctest.out.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出 -XX：MaxDirectoryMemorySize
 *
 * @author tangwei
 * @date 2019/1/23 11:30
 */
public class DirectMemorySizeOOM {

    private final static int _1MB = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeFeild = Unsafe.class.getDeclaredFields()[0];
        unsafeFeild.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeFeild.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }

    }

}
