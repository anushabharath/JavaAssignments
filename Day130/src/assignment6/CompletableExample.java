/*Task 6: Executors, Concurrent Collections, CompletableFuture
Use an ExecutorService to parallelize a task that calculates prime numbers up to a given number and then use CompletableFuture to write the results to a file asynchronously.
*/


package assignment6;


import java.util.concurrent.CompletableFuture;

class CompletableExample {
    public static void runExample() {
        CompletableFuture.supplyAsync(() -> "Hello, ")
                         .thenApplyAsync(result -> result + "World!")
                         .thenAcceptAsync(System.out::println)
                         .join();
    }
}