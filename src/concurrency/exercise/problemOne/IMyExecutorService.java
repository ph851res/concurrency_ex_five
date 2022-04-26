package concurrency.exercise.problemOne;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

public interface IMyExecutorService {
    void execute(Runnable r);
    IMyFuture submit(Callable c);
}
