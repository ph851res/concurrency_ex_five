package concurrency.exercise.problemOne;

public interface IMyFuture<T> extends Runnable {
    boolean isDone();
    T get();
}
