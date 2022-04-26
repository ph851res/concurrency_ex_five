package concurrency.exercise.five;

class MyExecutor {
    public static IMyExecutorService newMyThreadPoll(final int capacity) {
        return new MyThreadPool(capacity);
    }
}