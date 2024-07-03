package assignment;

import java.util.Stack;

public class SequenceInStack {
    
    public static boolean isSequenceInStack(Stack<Integer> stack, int[] sequence) {
        // If the sequence is empty, it is trivially present
        if (sequence.length == 0) {
            return true;
        }

        // Temporary stack to hold elements
        Stack<Integer> tempStack = new Stack<>();
        int seqIndex = sequence.length - 1; // Start from the end of the sequence

        // While there are elements in the stack
        while (!stack.isEmpty()) {
            // Pop an element from the stack
            int elem = stack.pop();
            // Push it into the temporary stack
            tempStack.push(elem);

            // Check if the current element matches the current sequence element
            if (elem == sequence[seqIndex]) {
                seqIndex--;
                // If we've matched the whole sequence, return true
                if (seqIndex < 0) {
                    // Restore the original stack
                    while (!tempStack.isEmpty()) {
                        stack.push(tempStack.pop());
                    }
                    return true;
                }
            } else {
                // Reset the sequence pointer if it was partially matched
                seqIndex = sequence.length - 1;
            }
        }

        // Restore the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        // If we finish the loop without matching the sequence, return false
        return false;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        int[] sequence1 = {6, 7, 8};
        System.out.println(isSequenceInStack(stack, sequence1)); // Output: true

        int[] sequence2 = {7, 8, 10};
        System.out.println(isSequenceInStack(stack, sequence2)); // Output: false
    }
}


