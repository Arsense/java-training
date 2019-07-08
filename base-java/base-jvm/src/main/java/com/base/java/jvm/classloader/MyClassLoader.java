package com.base.java.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Clay
 * @date 2018/12/21 11:16
 */
public class MyClassLoader extends ClassLoader {

    //设置盘符
    private String rootPath;

    public MyClassLoader(String rootPath){
        this.rootPath = rootPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //check if the class have been loaded
        Class<?> c = findLoadedClass(name);
        if(c!= null){
            return c;
        }
        //load the class
        byte[] classData = new byte[0];
        try {
            classData = getClassData(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(classData==null){
            throw new ClassNotFoundException();
        }
        else{
            c = defineClass(name,classData, 0, classData.length);
            return c;
        }
    }

    private byte[] getClassData(String className) throws IOException {
        String path = rootPath+"/"+className.replace('.', '/')+".class";

        InputStream inputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            inputStream = new FileInputStream(path);
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int temp = 0;
            while((temp = inputStream.read(buffer))!=-1){
                byteArrayOutputStream.write(buffer,0,temp);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            byteArrayOutputStream.close();
        }
        return null;

    }
}
