package com.xwy.one.wangwenjun.two.chapter20;

/**
 * @description:
 * @author: xwy
 * @create: 6:50 PM 2020/5/27
 **/

public class SimpleEncrypt {

    private static final String plain = "Hello ClasssLoader";

    private static final byte ENCRPY_FACTORY = (byte) 0xff;

    public static void main(String[] args) {
        byte[] bytes = plain.getBytes();
        byte[] encyypt = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            encyypt[i] = (byte)(bytes[i] ^ ENCRPY_FACTORY);
        }
        System.out.println(new String(encyypt));

        byte[] decrypt = new byte[encyypt.length];


    }

}