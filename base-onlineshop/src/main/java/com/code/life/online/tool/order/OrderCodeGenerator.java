package com.code.life.online.tool.order;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Clay
 * @date 2019/5/15 1:09
 */
public class OrderCodeGenerator {

    //自增长序列
    private int i = 0;


    public String getOrderCode() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-");
        return simpleDateFormat.format(date) + ++i;
    }


    public static void main(String[] args) {
        OrderCodeGenerator codeGenerator = new OrderCodeGenerator();
        for (int i = 0; i < 10;i++) {
            System.out.println(codeGenerator.getOrderCode());
        }

    }
}
