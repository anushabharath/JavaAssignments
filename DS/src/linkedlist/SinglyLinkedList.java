package linkedlist;
import java.util.Scanner;

public class SinglyLinkedList {

    // Node class represents each node in the linked list
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // LinkedList class manages operations on the linked list
    static class LinkedList {
        Node head; // head of the list

        // Method to insert a new node at the front of the list
        public void insertAtFront(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        // Method to insert a new node at the end of the list
        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        // Method to insert a new node at a specific position in the list
        public void insertAtPosition(int data, int position) {
            Node newNode = new Node(data);
            if (position < 1) {
                System.out.println("Invalid position. Position should be >= 1.");
                return;
            }
            if (position == 1) {
                newNode.next = head;
                head = newNode;
                return;
            }
            Node current = head;
            for (int i = 1; i < position - 1 && current != null; i++) {
                current = current.next;
            }
            if (current == null) {
                System.out.println("Invalid position. Position is beyond the length of the list.");
            } else {
                newNode.next = current.next;
                current.next = newNode;
            }
        }

        // Method to delete a node by key (value)
        public void deleteNodeByKey(int key) {
            Node temp = head, prev = null;
            if (temp != null && temp.data == key) {
                head = temp.next;
                return;
            }
            while (temp != null && temp.data != key) {
                prev = temp;
                temp = temp.next;
            }
            if (temp == null) return;
            prev.next = temp.next;
        }

        // Method to display the linked list
        public void display() {
            Node current = head;
            if (current == null) {
                System.out.println("Linked list is empty.");
                return;
            }
            System.out.print("Linked list: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nLinked List Operations:");
            System.out.println("1. Insert at front");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at specific position");
            System.out.println("4. Delete by key");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at front: ");
                    int dataFront = scanner.nextInt();
                    list.insertAtFront(dataFront);
                    break;
                case 2:
                    System.out.print("Enter data to insert at end: ");
                    int dataEnd = scanner.nextInt();
                    list.insertAtEnd(dataEnd);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    int dataPosition = scanner.nextInt();
                    System.out.print("Enter position to insert (1 to n): ");
                    int position = scanner.nextInt();
                    list.insertAtPosition(dataPosition, position);
                    break;
                case 4:
                    System.out.print("Enter key to delete: ");
                    int key = scanner.nextInt();
                    list.deleteNodeByKey(key);
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 6);

        scanner.close();
    }
}
