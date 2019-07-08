package com.demo.spring;

import java.io.InputStream;

/**
 * @author Clay
 * @date 2019/7/5 17:53
 */
public interface Resource {
    /**
     * 获取输入流
     */
    InputStream getInputstream() throws Exception;

}
