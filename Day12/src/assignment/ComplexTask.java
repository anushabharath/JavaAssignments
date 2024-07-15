package assignment;

import java.util.Random;
import java.util.concurrent.Callable;

public class ComplexTask implements Callable<String> {
    private final int taskId;

    public ComplexTask(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public String call() throws Exception {
        Random random = new Random();
        int sleepTime = random.nextInt(3000) + 1000; // Sleep between 1 to 4 seconds

        // Simulate complex calculation or I/O operation
        System.out.println("Task " + taskId + " is performing a complex calculation...");
        Thread.sleep(sleepTime);
        System.out.println("Task " + taskId + " has completed.");

        return "Result of Task " + taskId;
    }
}
