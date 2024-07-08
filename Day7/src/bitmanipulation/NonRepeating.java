package bitmanipulation;

import java.util.Arrays;

public class NonRepeating {

    // Function to find and print the two non-repeating elements in the array
    public static void nonRepeating(int[] arr) {
        // Step 1: XOR all elements in the array. The result will be the XOR of the two non-repeating elements
        int xor = 0;
        for (int n : arr) {
            xor ^= n;
        }

        // Step 2: Find a set bit (rightmost set bit in this case) in the XOR result
        int setBit = xor & ~(xor - 1);

        // Step 3: Divide elements into two sets based on the set bit and XOR within each set to find the two unique elements
        int x = 0, y = 0;
        for (int num : arr) {
            if ((num & setBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }

        // Print the two non-repeating elements
        System.out.println("Non-repeating elements in the array are: " + x + " and " + y);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4};
        System.out.println("Array is: " + Arrays.toString(arr));
        nonRepeating(arr);
    }
}
