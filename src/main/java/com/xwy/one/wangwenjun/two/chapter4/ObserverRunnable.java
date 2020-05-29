package com.xwy.one.wangwenjun.two.chapter4;

/**
 *
 * @description:
 *
 * @author: xwy
 *
 * @create: 4:08 PM 2020/5/18
**/

public class ObserverRunnable implements Runnable{

    final protected LifeCycleListener listener;

    public ObserverRunnable(LifeCycleListener listener) {
        this.listener = listener;
    }

    protected void notifyChange(final  RunnableEvent event){

        listener.onEvent(event);
    }

    @Override
    public void run() {

    }

    public enum RunnableState{
        RUNNING,ERROR,DONE;
    }

    public static class RunnableEvent{
        private final RunnableState state;
        private final Thread thread;
        private final Throwable cause;

        public RunnableEvent(RunnableState state, Thread thread, Throwable cause) {
            this.state = state;
            this.thread = thread;
            this.cause = cause;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getCause() {
            return cause;
        }
    }
}