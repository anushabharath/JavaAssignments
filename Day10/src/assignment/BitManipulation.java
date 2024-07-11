package assignment;

public class BitManipulation {

    // Function to count the number of set bits in a single integer
    public static int countSetBits(int num) {
        int count = 0;
        while (num > 0) {
            num &= (num - 1); // This operation reduces the number of set bits
            count++;
        }
        return count;
    }

    // Function to count the total number of set bits in all integers from 1 to n
    public static int totalSetBits(int n) {
        int totalCount = 0;
        for (int i = 1; i <= n; i++) {
            totalCount += countSetBits(i);
        }
        return totalCount;
    }

    public static void main(String[] args) {
        int n = 5; // Example value, you can change this to test with other values
        System.out.println("Total number of set bits from 1 to " + n + " is: " + totalSetBits(n));
    }
}
