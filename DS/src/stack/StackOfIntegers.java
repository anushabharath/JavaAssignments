package stack;

import java.util.Scanner;

public class StackOfIntegers {
    private int[] arr;
    private int top;

    public StackOfIntegers(int size) {
        arr = new int[size];
        top = -1;
    }

    public void push(int num) {
        if (top == arr.length - 1) {
            System.out.println("Stack is full");
        } else {
            top++;
            arr[top] = num;
        }
    }
    
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            int poppedElement = arr[top];
            top--;
            return poppedElement;
        }
    }

    public int getMax() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        int max = arr[0];
        for (int i = 1; i <= top; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }


    public int getMin() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        int min = arr[0];
        for (int i = 1; i <= top; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
    
    public int getPeek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the stack: ");
        int size = scanner.nextInt();

        StackOfIntegers obj = new StackOfIntegers(size);

        System.out.println("Input some elements into the stack:");
        for (int i = 0; i < size; i++) {
            int element = scanner.nextInt();
            obj.push(element);
        }
        System.out.println("Is the stack empty? " + obj.isEmpty());
        System.out.println("Maximum value: " + obj.getMax());
        System.out.println("Minimum value: " + obj.getMin());
        System.out.println("Peek element: " + obj.getPeek());
    }
}

