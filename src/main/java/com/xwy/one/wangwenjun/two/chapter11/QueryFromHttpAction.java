package com.xwy.one.wangwenjun.two.chapter11;

public class QueryFromHttpAction {

    public void execute(Context context) {

        context = ActionContext.getActionContext().getContext();
        String name = context.getName();
        String cardId = getCardId(name);
        context.setCardId(cardId);
    }

    private String getCardId(String name) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "123  " + Thread.currentThread().getName();
    }
}