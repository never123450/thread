package com.xwy.one.wangwenjun.three.atomic;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 10:00 PM 2020/5/28
**/

public class GetLockException extends Exception{
    public GetLockException(){
        super();
    }

    public GetLockException(String message){
        super(message);
    }
}