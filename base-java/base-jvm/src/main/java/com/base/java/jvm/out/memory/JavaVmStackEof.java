package com.base.java.jvm.out.memory;

/**
 *  栈的溢出
 * VM args -Xss128k 设置栈的大小
 * @author tangwei
 * @date 2019/1/23 9:59
 */
public class JavaVmStackEof {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) throws Throwable {
        JavaVmStackEof OOM = new JavaVmStackEof();

        try {
            OOM.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length" + OOM.stackLength);
            throw e;
        }

    }
}
