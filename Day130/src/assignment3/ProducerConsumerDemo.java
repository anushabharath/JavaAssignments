/*Task 3: Synchronization and Inter-thread Communication
Implement a producer-consumer problem using wait() and notify() methods to handle the correct processing sequence between threads.
*/

package assignment3;

import java.util.ArrayList;
import java.util.Random;

public class ProducerConsumerDemo {
    private static ArrayList<Integer> list = new ArrayList<>();
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread producerThread = new Thread(() -> {
            try {
                producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producerThread.start();
        consumerThread.start();
    }

    public static void producer() throws InterruptedException {
        while (true) {
            Thread.sleep(500);
            synchronized (lock) {
                if (list.size() == 10) {
                    System.out.println("Queue full.. Waiting to add");
                    lock.wait();
                }
                int value = new Random().nextInt(100);
                list.add(value);
                System.out.println("Added element: " + value);
                lock.notify();
            }
        }
    }

    public static void consumer() throws InterruptedException {
        while (true) {
            Thread.sleep(500);
            synchronized (lock) {
                if (list.isEmpty()) {
                    System.out.println("Queue is empty... Waiting to remove");
                    lock.wait();
                }
                int removedValue = list.remove(0);
                System.out.println("Removed element: " + removedValue);
                lock.notify();
            }
        }
    }
}
