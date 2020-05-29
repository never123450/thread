package com.xwy.one.wangwenjun.two.chapter18;

public class RealResult implements Result {

    private final Object resultValue;

    public RealResult(Object resultValue) {
        this.resultValue = resultValue;
    }

    @Override
    public Object getResultVaule() {
        return this.resultValue;
    }
}