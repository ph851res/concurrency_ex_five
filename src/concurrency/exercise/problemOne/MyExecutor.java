package concurrency.exercise.problemOne;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyExecutor {
    public static IMyExecutorService newMyThreadPoll(final int capacity) {
        return new MyThreadPool(capacity);
    }
}