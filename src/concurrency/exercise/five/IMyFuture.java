package concurrency.exercise.five;

public interface IMyFuture<T> extends Runnable {
    boolean isDone();
    T get();
}
