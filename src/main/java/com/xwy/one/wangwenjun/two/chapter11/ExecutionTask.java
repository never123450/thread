package com.xwy.one.wangwenjun.two.chapter11;

/**
 * @description:
 * @author: xwy
 * @create: 4:09 PM 2020/5/22
 **/

public class ExecutionTask implements Runnable {


    private QueryFromDBAction queryFromDBAction = new QueryFromDBAction();
    private QueryFromHttpAction queryFromHttpAction = new QueryFromHttpAction();

    @Override
    public void run() {
//        final Context context = new Context();
        Context context = ActionContext.getActionContext().getContext();

        queryFromDBAction.execute(context);
        System.out.println("The name is :" + context.getName());

        queryFromHttpAction.execute(context);
        System.out.println("The cardId is :" + context.getCardId());
    }

}