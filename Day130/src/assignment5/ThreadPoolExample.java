/*Task 5: Thread Pools and Concurrency Utilities
Create a fixed-size thread pool and submit multiple tasks that perform complex calculations or I/O operations and observe the execution.
*/
package assignment5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ComplexCalculation implements Runnable {
    private final int taskId;

    public ComplexCalculation(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("Task " + taskId + " is starting.");

        // Simulate a complex calculation by sleeping for a random time
        try {
            long duration = (long) (Math.random() * 10);
            System.out.println("Task " + taskId + " is performing a complex calculation for " + duration + " seconds.");
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task " + taskId + " is completed.");
    }
}

public class ThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed-size thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        // Submit 10 tasks to the executor service
        for (int i = 1; i <= 10; i++) {
            executorService.submit(new ComplexCalculation(i));
        }

        // Shutdown the executor service
        executorService.shutdown();

        try {
            // Wait for all tasks to complete
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            e.printStackTrace();
        }

        System.out.println("All tasks are completed.");
    }
}
