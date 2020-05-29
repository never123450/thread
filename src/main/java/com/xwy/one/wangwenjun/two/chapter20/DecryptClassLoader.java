package com.xwy.one.wangwenjun.two.chapter20;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @description: 把class文件解密之后加载
 * @author: xwy
 * @create: 7:03 PM 2020/5/27
 **/

public class DecryptClassLoader extends ClassLoader {
    private final static String DEFAULT_DIR = "/Users/xuwenyan/Downloads/Test.class";
    private String dir = DEFAULT_DIR;

    public DecryptClassLoader() {
        super();
    }

    public DecryptClassLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File classFile = new File(dir, classPath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("The Class " + name + " not found under [ " + dir + " ]");
        }
        byte[] classBytes = loadClassBytes(classFile);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("load The Class " + name + " faild");
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                baos.write(data ^ EncryptUtils.ENCRPY_FACTORY);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}