package assignment;

public class Counter {
    private int count;

    public Counter() {
        this.count = 0;
    }

    // Synchronized method to increment the counter
    public synchronized void increment() {
        count++;
        System.out.println(Thread.currentThread().getName() + " incremented to " + count);
    }

    // Synchronized method to decrement the counter
    public synchronized void decrement() {
        count--;
        System.out.println(Thread.currentThread().getName() + " decremented to " + count);
    }

    // Synchronized method to get the current count
    public synchronized int getCount() {
        return count;
    }
}

