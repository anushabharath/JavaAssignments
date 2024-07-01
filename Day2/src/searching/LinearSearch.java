package searching;

import java.util.Scanner;


public class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       
        System.out.print("Enter the number of elements in the array: ");
        int size = scanner.nextInt();
          
        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
          
        System.out.print("Enter the target element to search: ");
        int target = scanner.nextInt();
        
        boolean isFound = linearSearch(arr, target);
               
        if (isFound) {
            System.out.println("Element found in the array.");
        } else {
            System.out.println("Element not found in the array.");
        }
        
        scanner.close();
    }

    public static boolean linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return true; 
            }
        }
        return false; 
    }
}


