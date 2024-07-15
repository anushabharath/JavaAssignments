package assignment;

import java.util.LinkedList;
import java.util.Queue;

class Buffer {
    private final int maxSize;
    private final Queue<Integer> queue = new LinkedList<>();

    Buffer(int size) {
        this.maxSize = size;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (queue.size() == maxSize) {
            wait(); // Wait until there's space in the buffer
        }
        queue.offer(value);
        System.out.println("Produced: " + value);
        notifyAll(); // Notify consumers that they can consume
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait(); // Wait until there's data to consume
        }
        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notifyAll(); // Notify producers that they can produce
        return value;
    }
}
