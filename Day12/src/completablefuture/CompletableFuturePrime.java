package completablefuture;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFuturePrime {
    public static List<Integer> calculatePrime(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrime(int x) {
        if (x <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0)
                return false;
        }
        return true;
    }

    public static void writeToFile(List<Integer> primes, String filename) {
        try (PrintWriter writer = new PrintWriter(new File(filename))) {
            for (Integer prime : primes) {
                writer.println(prime);
            }
            System.out.println("Prime numbers written to the file: " + filename);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int range = 1000;
        int tasks = 4;
        String filename = "D://aaa.txt";

        ExecutorService executor = Executors.newFixedThreadPool(tasks);
        List<Future<List<Integer>>> futures = new ArrayList<>();
        int limit = range / tasks;

        for (int i = 0; i < tasks; i++) {
            int start = i * limit + 1;
            int end = (i == tasks - 1) ? range : (i + 1) * limit;

            futures.add(executor.submit(() -> calculatePrime(start, end)));
        }

        List<Integer> primeNumbers = new ArrayList<>();
        for (Future<List<Integer>> f : futures) {
            try {
                primeNumbers.addAll(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        CompletableFuture<Void> writeToFileFuture = CompletableFuture.runAsync(() -> writeToFile(primeNumbers, filename));
        writeToFileFuture.get(); // Wait for the write operation to complete

        // Run the CompletableExample
        CompletableExample.runExample();
    }
}