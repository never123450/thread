package com.xwy.two.concurrent.chapter4;

/***************************************
 * @author:xwy
 * @Date:2019年09月14日21:39:06
 ***************************************/
public interface LifeCycleListener {
    
    void onEvent(ObservableRunnable.RunnableEvent event);
}
