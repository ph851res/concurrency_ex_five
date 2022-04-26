package concurrency.exercise.five;

import java.util.concurrent.*;

public class MyExecutorCompletionService<T> implements IMyCompletionService {
    private final IMyExecutorService myExecutor;
    private final BlockingQueue<IMyFuture<T>> myCompletionQueue;
    public MyExecutorCompletionService(IMyExecutorService myExecutor) {
        this.myExecutor=myExecutor;
        this.myCompletionQueue=new LinkedBlockingQueue<IMyFuture<T>>();
    }

    @Override
    public IMyFuture<T> take() throws InterruptedException{
        return myCompletionQueue.take();
    }

    @Override
    public IMyFuture<T> submit(Callable c) {
        IMyFuture<T> t = new TestQueueingFuture<>(c, myCompletionQueue);
        myExecutor.execute(t);
        return t;
    }
}
