package com.xwy.one.wangwenjun.two.chapter20;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @description: 把文件加密
 * @author: xwy
 * @create: 6:55 PM 2020/5/27
 **/

public final class EncryptUtils {

    public static final byte ENCRPY_FACTORY = (byte) 0xff;

    private EncryptUtils() {
    }


    /**
     * 把source文件加密到target中
     *
     * @param source
     * @param target
     */
    public static void doEncrpy(String source, String target) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target);
        ) {
            int data;
            while ((data = fis.read()) != -1) {
                fos.write(data ^ ENCRPY_FACTORY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        doEncrpy("/Users/xuwenyan/Downloads/Test.class", "/Users/xuwenyan/Downloads/Test.class");
    }

}