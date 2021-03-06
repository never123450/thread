package com.xwy.one.wangwenjun.two.chapter4;

import java.util.List;

/**
 *
 * @description: 
 *
 * @author: xwy
 *
 * @create: 4:18 PM 2020/5/18
**/

public class ThreadLifeCycleObserver implements LifeCycleListener{

    private final Object LOCK = new Object();

    public void concurrentQuery(List<String> ids){
        if (ids == null || ids.isEmpty())
            return;

        ids.stream().forEach(id -> new Thread(new ObserverRunnable(this){
            @Override
            public void run(){
                try {
                    notifyChange((new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null)));
                    System.out.println("query for the id:"+id);
                    Thread.sleep(1000L);
                    notifyChange((new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null)));
                }catch (Exception e){
                    notifyChange((new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),null)));
                }
            }
        },id).start());
    }

    @Override
    public void onEvent(ObserverRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("The runnable ["+event.getThread().getName() +"] data changed and state is [ " + event.getThread().getState() );
            if (event.getState() != null){
                System.out.println("The runnable [ " +event.getThread().getName() + "] process failed");
                event.getCause().printStackTrace();
            }
        }
    }
}