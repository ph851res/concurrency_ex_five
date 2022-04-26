package concurrency.exercise.problemOne;

import java.util.concurrent.BlockingQueue;

// never used, TestQueueingFuture is used
public class MyQueueingFuture<T> extends MyFutureTask{
    private final IMyFuture<T> myFutureTask;
    private final BlockingQueue<IMyFuture<T>> myCompletionQueue;
    public MyQueueingFuture(IMyFuture<T> myFutureTask, BlockingQueue<IMyFuture<T>> myCompletionQueue) {
        super();
        this.myFutureTask=myFutureTask;
        this.myCompletionQueue=myCompletionQueue;
    }
    public void done() { myCompletionQueue.add(myFutureTask); }
}
