package assignment;

public class SwapDemo {
    public static void main(String[] args) {
        // Swap elements in an Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Before swap: " + java.util.Arrays.toString(intArray));
        ArrayUtils.swap(intArray, 1, 3);
        System.out.println("After swap: " + java.util.Arrays.toString(intArray));

        // Swap elements in a String array
        String[] strArray = {"apple", "banana", "cherry", "date"};
        System.out.println("Before swap: " + java.util.Arrays.toString(strArray));
        ArrayUtils.swap(strArray, 0, 2);
        System.out.println("After swap: " + java.util.Arrays.toString(strArray));

        // Swap elements in a Double array
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        System.out.println("Before swap: " + java.util.Arrays.toString(doubleArray));
        ArrayUtils.swap(doubleArray, 2, 3);
        System.out.println("After swap: " + java.util.Arrays.toString(doubleArray));
    }
}

