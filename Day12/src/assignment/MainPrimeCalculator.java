package assignment;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainPrimeCalculator {
    public static void main(String[] args) {
        int maxNumber = 1000;
        int numThreads = 4;
        int chunkSize = maxNumber / numThreads;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        List<Future<List<Integer>>> futures = new ArrayList<>();

        // Submit tasks to executor service
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize + 1;
            int end = (i + 1) * chunkSize;
            PrimeCalculator calculator = new PrimeCalculator(start, end);
            futures.add(executorService.submit(calculator));
        }

        // Collect results from futures
        List<Integer> allPrimes = new ArrayList<>();
        for (Future<List<Integer>> future : futures) {
            try {
                allPrimes.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Use CompletableFuture to write to file asynchronously
        CompletableFuture.runAsync(() -> writeToFile(allPrimes))
                .thenRun(() -> System.out.println("Primes written to primes.txt"));

        executorService.shutdown();
    }

    private static void writeToFile(List<Integer> primes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("primes.txt"))) {
            for (int prime : primes) {
                writer.write(prime + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
