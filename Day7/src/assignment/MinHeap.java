package assignment;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Method to get the minimum element (root) of the heap
    public int getMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    // Method to insert a new element into the heap
    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    // Method to delete the minimum element (root) from the heap
    public int deleteMin() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    // Heapify up to maintain the heap property after insertion
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;

        if (index > 0 && heap.get(index) < heap.get(parentIndex)) {
            swap(index, parentIndex);
            heapifyUp(parentIndex);
        }
    }

    // Heapify down to maintain the heap property after deletion
    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallest = index;

        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallest)) {
            smallest = leftChildIndex;
        }

        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallest)) {
            smallest = rightChildIndex;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    // Swap elements at two indices
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    // Main method for testing
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();
        minHeap.insert(3);
        minHeap.insert(1);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(2);
        minHeap.insert(4);

        System.out.println("Min element: " + minHeap.getMin()); // Should print 1

        System.out.println("Deleted min element: " + minHeap.deleteMin()); // Should delete 1
        System.out.println("New min element: " + minHeap.getMin()); // Should print 2

        System.out.println("Deleted min element: " + minHeap.deleteMin()); // Should delete 2
        System.out.println("New min element: " + minHeap.getMin()); // Should print 3
    }
}





