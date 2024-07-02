package assignment;

import java.util.Stack;

public class StackSort {
    // Function to sort a stack using a temporary stack
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            // Pop the top element from the original stack
            int current = stack.pop();

            // While the temporary stack is not empty and the top element
            // of the temporary stack is greater than the current element
            while (!tempStack.isEmpty() && tempStack.peek() > current) {
                // Pop elements from the temporary stack and push them back
                // onto the original stack
                stack.push(tempStack.pop());
            }

            // Push the current element onto the temporary stack
            tempStack.push(current);
        }

        // Transfer all elements from the temporary stack back to the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted stack: " + stack);
    }
}

