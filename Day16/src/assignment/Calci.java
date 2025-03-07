package assignment;

// Calculator.java
public class Calci {

    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract one integer from another
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two integers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide one integer by another
    public int divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
        return a / b;
    }
}
