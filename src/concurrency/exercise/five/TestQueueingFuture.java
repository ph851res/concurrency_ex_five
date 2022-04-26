package concurrency.exercise.five;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class TestQueueingFuture<T> implements IMyFuture{
    private Callable<T> callable;
    private T result;
    private boolean finish;
    private final BlockingQueue<IMyFuture<T>> myCompletionQueue;
    public TestQueueingFuture(Callable callable, BlockingQueue<IMyFuture<T>> myCompletionQueue) {
        this.callable = callable;
        this.myCompletionQueue=myCompletionQueue;
    }

    @Override
    public boolean isDone() {
        return finish;
    }

    @Override
    public T get() {
        return result;
    }

    public void done() {
        myCompletionQueue.add(this);
    }

    @Override
    public void run() {
        System.out.println("and in here?");
        try {
            result = callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finish = true;
        done();
    }
}
