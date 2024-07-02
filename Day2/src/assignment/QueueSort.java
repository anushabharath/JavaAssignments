package assignment;
/*
STEPS:

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

        while (!queue.isEmpty()) {
            int current = queue.poll();

            // Move elements from stack to queue if they are greater than the current element
            while (!stack.isEmpty() && stack.peek() > current) {
                queue.add(stack.pop());
            }

            // Push the current element onto the stack
            stack.push(current);
        }

        // Move sorted elements back to the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(5);
        queue.add(1);
        queue.add(3);
        queue.add(2);
        queue.add(4);

        System.out.println("Original Queue: " + queue);
        sortQueue(queue);
        System.out.println("Sorted Queue: " + queue);
    }
}


