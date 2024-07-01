package queue;
import java.util.Scanner;

public class Queue {
    Node front, rear; // front and rear nodes of the queue

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // Constructor to initialize an empty queue
    public Queue() {
        this.front = this.rear = null;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to enqueue an element to the queue
    public void enQueue(int data) {
        Node newNode = new Node(data);

        // If queue is empty, new node is both front and rear
        if (isEmpty()) {
            front = rear = newNode;
            return;
        }

        // Add the new node at the end of queue and change rear
        rear.next = newNode;
        rear = newNode;
    }

    // Method to dequeue an element from the queue
    public void deQueue() {
        // If queue is empty, return null
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to dequeue.");
            return;
        }

        // Store previous front and move front one node ahead
        Node temp = front;
        front = front.next;

        // If front becomes null, then change rear also as null
        if (front == null) {
            rear = null;
        }

        System.out.println("Dequeued element: " + temp.data);
    }

    // Method to display the queue elements
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }

        Node current = front;
        System.out.print("Queue elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int value = scanner.nextInt();
            queue.enQueue(value);
        }

        // Display the queue elements
        queue.display();

        // Perform dequeue operation
        queue.deQueue();
        queue.display();

        scanner.close();
    }
}

