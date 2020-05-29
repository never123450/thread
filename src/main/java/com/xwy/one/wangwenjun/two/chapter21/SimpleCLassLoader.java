package com.xwy.one.wangwenjun.two.chapter21;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @description: 自定义类加载器
 * @author: xwy
 * @create: 7:48 PM 2020/5/26
 **/

public class SimpleCLassLoader extends ClassLoader {
    private final static String DEFAULT_DIR = "/Users/xuwenyan/Downloads/study/thread/target/classes/";

    private String dir = DEFAULT_DIR;

    public SimpleCLassLoader() {
        super();
    }

    public static String getDefaultDir() {
        return DEFAULT_DIR;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    private String classLoaderName;

    public SimpleCLassLoader(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public SimpleCLassLoader(String classLoaderName, ClassLoader parent) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    /**
     * x.x.x.x.A
     * x/x/x/x/A
     *
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File classFile = new File(dir, classPath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("the class " + name + " not fount under " + dir+classPath);
        }
        byte[] classBytes = loadClassBytes(classFile);
        if (null == classBytes || classBytes.length == 0)
            throw new ClassNotFoundException("load class " + name + " faild");

        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             FileInputStream fis = new FileInputStream(classFile)) {

            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = null;

//        if (name.startsWith("java.")) {
//            try {
//                ClassLoader system = ClassLoader.getSystemClassLoader();
//                clazz = system.loadClass(name);
//                if (clazz != null) {
//                    if (resolve)
//                        resolveClass(clazz);
//                    return clazz;
//                }
//            } catch (Exception e) {
//                // ignore
//            }
//        }
        try {
            clazz = findClass(name);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (clazz == null && getParent() != null) {
            getParent().loadClass(name);
        }

        return clazz;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }
}