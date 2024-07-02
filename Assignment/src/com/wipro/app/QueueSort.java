package com.wipro.app;

/*
 * 
Steps:

1. Initialize: Create an auxiliary stack.

2. Repeat the following steps until the queue is sorted:

--> Dequeue all elements from the queue one by one.
--> Keep track of the minimum element.
--> Push each dequeued element onto the stack except the minimum element.
--> Enqueue elements from the stack back to the queue.
--> Enqueue the minimum element back to the queue.*/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSort {
    public static void sortQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < queue.size(); i++) {
            // Find the minimum element in the queue
            int minIndex = -1;
            int minValue = Integer.MAX_VALUE;
            int n = queue.size();
            for (int j = 0; j < n; j++) {
                int current = queue.poll();
                if (current < minValue && j <= n - i - 1) {
                    minValue = current;
                    minIndex = j;
                }
                queue.add(current);
            }

            // Move elements to the stack except the minimum element
            for (int j = 0; j < n; j++) {
                int current = queue.poll();
                if (j != minIndex) {
                    stack.push(current);
                }
            }

            // Re-enqueue elements from the stack back to the queue
            while (!stack.isEmpty()) {
                queue.add(stack.pop());
            }

            // Enqueue the minimum element back to the queue
            queue.add(minValue);
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(4);

        System.out.println("Queue before sorting: " + queue);
        sortQueue(queue);
        System.out.println("Queue after sorting: " + queue);
    }
}

