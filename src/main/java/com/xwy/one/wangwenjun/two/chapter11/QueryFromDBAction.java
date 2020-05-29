package com.xwy.one.wangwenjun.two.chapter11;

public class QueryFromDBAction {
    public void execute(Context context){

        try {
            Thread.sleep(1000L);
            String name = "xxx" + Thread.currentThread().getName();
//            context.setName(name);
            ActionContext.getActionContext().getContext().setName(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}