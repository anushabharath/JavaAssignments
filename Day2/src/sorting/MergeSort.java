package sorting;

import java.util.Arrays;

public class MergeSort {

    // Merges two subarrays of array[].
    // First subarray is array[l..m]
    // Second subarray is array[m+1..r]
    static void merge(int array[], int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int leftArray[] = new int[n1];
        int rightArray[] = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i)
            leftArray[i] = array[left + i];
        for (int j = 0; j < n2; ++j)
            rightArray[j] = array[mid + 1 + j];

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // Main function that sorts array[left..right] using merge()
    static void mergeSort(int array[], int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    // Main class to test the above methods
    public static void main(String args[]) {
        int[] data = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Unsorted Array");
        System.out.println(Arrays.toString(data));

        int size = data.length;

        // Call mergeSort() on array data
        MergeSort.mergeSort(data, 0, size - 1);

        System.out.println("Sorted Array in Ascending Order");
        System.out.println(Arrays.toString(data));
    }
}
