package concurrency.exercise.five;

import java.util.concurrent.Callable;

public class MyFutureTask<T> implements Runnable, IMyFuture{
    private Callable<T> callable;
    private T result;
    private boolean finish;
    //public MyFutureTask(){}
    public MyFutureTask(Callable callable) {
        this.callable = callable;
    }

    @Override
    public boolean isDone() {
        return finish;
    }

    @Override
    public T get() {
        while (!finish) {
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    @Override
    public void run() {
        try {
            result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finish = true;

        synchronized (this) {
            notifyAll();
        }
    }
}
