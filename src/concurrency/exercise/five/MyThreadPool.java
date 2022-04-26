package concurrency.exercise.five;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyThreadPool implements IMyExecutorService{
    private BlockingQueue<Runnable> taskQueue;
    private List<WorkerThread> workerThreads;
    private final int capacity;

    public MyThreadPool(final int capacity) {
        this.capacity = capacity;
        taskQueue = new LinkedBlockingQueue<>();
        workerThreads = new ArrayList<>(capacity);
        for (int i=0; i < capacity; i++) {
            WorkerThread t = new WorkerThread(taskQueue);
            t.setName("Thread "+i);
            t.start();
            workerThreads.add(t);
        }
    }
    public void execute(Runnable r) {
        try {
            taskQueue.put(r);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MyFutureTask submit(Callable c) {
        System.out.println("submit");
        MyFutureTask futureTask = new MyFutureTask(c);
        try {
            taskQueue.put(futureTask);
            System.out.println("in Queue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return futureTask;
    }
}
