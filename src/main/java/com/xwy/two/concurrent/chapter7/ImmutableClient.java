package com.xwy.two.concurrent.chapter7;

import java.util.stream.IntStream;

/***************************************
 * @author:xwy
 * @Date:2019年09月17日19:32:58
 ***************************************/
public class ImmutableClient {
    public static void main(String[] args) {

        //Share data
        Person person = new Person("Alex", "GuanSu");
        IntStream.range(0, 5).forEach(i ->
                new UsePersonThread(person).start()
        );
    }
}
