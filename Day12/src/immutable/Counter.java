package immutable;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter
{
    public static void main(String args[])
    {
        Count obj = new Count();
        Runnable tasks = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++) {
                    obj.increment();

                }
                System.out.println(Thread.currentThread().getName()+" Total Count :"+obj.getTotal());
            }
        };
        Thread t1 = new Thread(tasks);
        Thread t2 = new Thread(tasks);
        t1.start();
        t2.start();
    }

}
 