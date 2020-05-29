package com.xwy.one.wangwenjun.two.chapter18;

/**
 * @description:
 * @author: xwy
 * @create: 3:30 PM 2020/5/24
 **/

/**
 * {@link ActiveObject#makeString(int, char)}
 */
public class MakeStringRequest extends MethodRequest {

    private final int count;

    private final char fillChar;

    public MakeStringRequest(Servant servant, FutureResult futureResult, int count, char fillChar) {
        super(servant, futureResult);
        this.fillChar = fillChar;
        this.count = count;
    }

    @Override
    public void execute() {
        Result result = servant.makeString(count,fillChar);
        futureResult.setResult(result);
    }
}