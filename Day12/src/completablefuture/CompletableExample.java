package completablefuture;

import java.util.concurrent.CompletableFuture;

class CompletableExample {
    public static void runExample() {
        CompletableFuture.supplyAsync(() -> "Hello, ")
                         .thenApplyAsync(result -> result + "World!")
                         .thenAcceptAsync(System.out::println)
                         .join();
    }
}