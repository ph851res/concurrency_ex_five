package concurrency.exercise.problemOne;

import java.util.concurrent.*;

public class MyExecutorMain {
    public static void main(String[] args) {
        //CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
        //ExecutorCompletionService executorCompletionService= new ExecutorCompletionService( executorService );
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Runnable r = () -> {
            System.out.println(Thread.currentThread().getName() + " is executing task.");
        };

        Callable c = new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is executing task.");
                return "test";
            }
        };
        ////// Problem 1 MyExecutor //////

        IMyExecutorService iMyExecutorService = MyExecutor.newMyThreadPoll(4);
        iMyExecutorService.execute(r);

        ////// Problem 2 Future //////

        /*IMyExecutorService iMyExecutorService = MyExecutor.newMyThreadPoll(4);
        IMyFuture<String> myFuture = iMyExecutorService.submit(c);

        System.out.println(myFuture.isDone());
        System.out.println(myFuture.get());
        System.out.println(myFuture.isDone());*/

        ////// Problem 3 ExecutorCompletionService //////

        /*IMyExecutorService iMyExecutorService = MyExecutor.newMyThreadPoll(4);
        IMyCompletionService<String> myCompletionService=new MyExecutorCompletionService<String>(iMyExecutorService);

        for (int i = 0; i < 10; i++) {
            myCompletionService.submit(c);
        }
        for (int i = 0; i < 10; i++) {
            try {
                IMyFuture<String> myFuture = myCompletionService.take();
                System.out.println(myFuture.get());
                System.out.println("Durchlauf "+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
    }
}
