package com.demo.spring;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author tangwei
 * @date 2019/7/5 17:50
 */
public class ResourceUrl implements Resource {
    /**
     * 类库URL
     */
    private final URL url;

    /**
     * 需要一个类库URL
     */
    public ResourceUrl(URL url) {
        this.url = url;
    }


    /**
     * 从URL中获取输入流
     */
    @Override
    public InputStream getInputstream() throws Exception {
        URLConnection urlConnection = url.openConnection();
        urlConnection.connect();
        return urlConnection.getInputStream();
    }
}
