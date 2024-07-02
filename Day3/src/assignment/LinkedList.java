package assignment;

//Class to represent a node in the linked list
class Node {
 int data;
 Node next;

 Node(int data) {
     this.data = data;
     this.next = null;
 }
}

//Class to represent the linked list
class LinkedList {
 Node head;

 // Method to remove duplicates from a sorted linked list
 public void removeDuplicates() {
     Node current = head;

     // Traverse the list until the end
     while (current != null && current.next != null) {
         // If current node is equal to the next node, skip the next node
         if (current.data == current.next.data) {
             current.next = current.next.next;
         } else {
             // Otherwise, move to the next node
             current = current.next;
         }
     }
 }

 // Method to insert a new node at the end of the list
 public void insert(int data) {
     Node newNode = new Node(data);

     if (head == null) {
         head = newNode;
         return;
     }

     Node last = head;
     while (last.next != null) {
         last = last.next;
     }
     last.next = newNode;
 }

 // Method to print the linked list
 public void printList() {
     Node temp = head;
     while (temp != null) {
         System.out.print(temp.data + " ");
         temp = temp.next;
     }
     System.out.println();
 }

 public static void main(String[] args) {
     LinkedList list = new LinkedList();
     list.insert(1);
     list.insert(1);
     list.insert(2);
     list.insert(3);
     list.insert(3);
     list.insert(4);
     list.insert(5);
     list.insert(5);

     System.out.println("Original list:");
     list.printList();

     list.removeDuplicates();

     System.out.println("List after removing duplicates:");
     list.printList();
 }
}
