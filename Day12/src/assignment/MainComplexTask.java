package assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainComplexTask {
    public static void main(String[] args) {
        // Create a fixed-size thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // List to hold Future objects
        List<Future<String>> futures = new ArrayList<>();

        // Submit multiple tasks to the executor service
        for (int i = 1; i <= 10; i++) {
            ComplexTask task = new ComplexTask(i);
            Future<String> future = executorService.submit(task);
            futures.add(future);
        }

        // Retrieve and print the results of the tasks
        for (Future<String> future : futures) {
            try {
                // Get the result of the task
                String result = future.get();
                System.out.println(result);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the executor service
        executorService.shutdown();
    }
}
