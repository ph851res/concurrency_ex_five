package concurrency.exercise.five;

import java.util.concurrent.Callable;

public interface IMyExecutorService {
    void execute(Runnable r);
    IMyFuture submit(Callable c);
}
