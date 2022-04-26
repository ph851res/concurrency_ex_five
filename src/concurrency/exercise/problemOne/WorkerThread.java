package concurrency.exercise.problemOne;

import java.util.concurrent.BlockingQueue;

public class WorkerThread extends Thread{
    private BlockingQueue<Runnable> taskQueue;
    public WorkerThread(BlockingQueue<Runnable> taskQueue) {
        this.taskQueue=taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            Runnable r = taskQueue.poll();
            if (r != null) {
                r.run();
            }
        }
    }
}
