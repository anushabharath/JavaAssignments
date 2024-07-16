package completablefuture;


import java.io.File;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CompletableFuturePrime
{
    public static List<Integer> calculatePrime(int range)
    {
        List<Integer> pr = new ArrayList<>();

        for(int i=2;i<=range;i++)
        {
            if(isPrime(i))
            {
                pr.add(i);
            }
        }
        return pr;
    }
    public static boolean isPrime(int x)
    {
        if(x<=1)
            return false;
      for(int i=2;i<=Math.sqrt(x);i++)
      {
          if(x%i==0)
              return  false;
      }
      return true;
    }
    public static void writeToFile(List<Integer> p)
    {
        try (PrintWriter wr = new PrintWriter(new File("D://aaa.txt"))){
            for(Integer prime : p)
            {
                wr.println(prime);
            }
            System.out.println("Written to the file");
        }
        catch (Exception e)
        {

        }
    }


    public static void main(String args[]) throws ExecutionException, InterruptedException {
        int range = 1000;

        int tasks = 4;

        ExecutorService executor = Executors.newFixedThreadPool(tasks);
        List<Future<List<Integer>>> futures = new ArrayList<>();
        int limit = range/tasks;

        for(int i=0;i<tasks;i++)
        {

            int s = i*limit+1;
            int e =(i==tasks-1)? range:(i+1)*limit;


        futures.add(executor.submit(()-> calculatePrime(e)));

        }
        List<Integer> primenumbers = new ArrayList<>();
        for(Future<List<Integer>> f : futures)
        {
            try {
                primenumbers.addAll(f.get());
            }
            catch(Exception e)
            {

            }
        }
              executor.shutdown();

        CompletableFuture.runAsync(()-> writeToFile(primenumbers));

     }
}