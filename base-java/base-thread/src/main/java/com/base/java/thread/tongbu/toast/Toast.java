package com.base.java.thread.tongbu.toast;

/**
 * @author Clay
 * @date 2018/12/13 14:47
 */
public class Toast {

    public enum Status {DRY, BUFFERED, JAMMED}
    private Status status = Status.DRY;
    private final int count;

    public void buffer () { status = Status.BUFFERED; }
    public void jammed () { status = Status.JAMMED; }
    public Toast(int count) { this.count = count; }
    public Status getStatus() {return  status;}

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Toast{" +
                "status=" + status +
                ", count=" + count +
                '}';
    }




}
