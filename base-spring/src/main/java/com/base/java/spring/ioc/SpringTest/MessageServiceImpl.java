package com.base.java.spring.ioc.SpringTest;

/**
 * @author tangwei
 * @date 2018/12/21 9:34
 */
public class MessageServiceImpl implements MessageService{
    @Override
    public String getMessage() {
        return "message come in";
    }
}
