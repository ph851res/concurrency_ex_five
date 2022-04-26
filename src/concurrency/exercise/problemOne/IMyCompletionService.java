package concurrency.exercise.problemOne;

import java.util.concurrent.Callable;

public interface IMyCompletionService<T> {
    IMyFuture<T> take() throws InterruptedException;
    IMyFuture<T> submit(Callable c);
}
