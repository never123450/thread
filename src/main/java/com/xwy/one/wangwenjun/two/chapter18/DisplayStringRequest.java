package com.xwy.one.wangwenjun.two.chapter18;

/**
 * @description:
 * @author: xwy
 * @create: 3:34 PM 2020/5/24
 **/

public class DisplayStringRequest extends MethodRequest {
    private final String text;

    public DisplayStringRequest(Servant servant, FutureResult futureResult, String text) {
        super(servant, futureResult);
        this.text = text;
    }

//    public DisplayStringRequest(Servant servant,  String text) {
//        this.servant = servant;
//        this.text = text;
//    }

    @Override
    public void execute() {
        this.servant.displayString(text);
    }
}