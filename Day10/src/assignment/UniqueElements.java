package assignment;

public class UniqueElements {

    public static void findUniqueElements(int[] arr) {
        // Step 1: XOR all elements to get the XOR of the two unique elements
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }

        // Step 2: Find a set bit in the XOR result
        int setBit = xor & ~(xor - 1);

        // Step 3: Separate the array into two groups and find the unique elements
        int num1 = 0, num2 = 0;
        for (int num : arr) {
            if ((num & setBit) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        // num1 and num2 are the two unique elements
        System.out.println("The two unique elements are: " + num1 + " and " + num2);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 1, 4}; // Example array
        findUniqueElements(arr);
    }
}

