package assignment; 

public class CircularQueueBinarySearch {
    // Function to perform binary search on the circular queue
    public static int circularQueueBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid;
            }

            // Determine which half is sorted
            if (arr[left] <= arr[mid]) {
                // Left half is sorted
                if (arr[left] <= target && target < arr[mid]) {
                    // Target is in the left half
                    right = mid - 1;
                } else {
                    // Target is in the right half
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (arr[mid] < target && target <= arr[right]) {
                    // Target is in the right half
                    left = mid + 1;
                } else {
                    // Target is in the left half
                    right = mid - 1;
                }
            }
        }

        // Target not found
        return -1;
    }

    public static void main(String[] args) {
        int[] circularQueue = {12, 14, 18, 21, 3, 6, 8, 9};  // Example circular queue
        int target = 8;  // Element to search for

        int result = circularQueueBinarySearch(circularQueue, target);

        if (result != -1) {
            System.out.println("Element found at index: " + result);
        } else {
            System.out.println("Element not found in the circular queue.");
        }
    }
}

