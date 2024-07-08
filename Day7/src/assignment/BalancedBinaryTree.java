package assignment;

//Definition for a binary tree node
class TreeNode {
int val;
TreeNode left;
TreeNode right;

TreeNode(int x) {
   val = x;
}
}

public class BalancedBinaryTree {

// Function to check if the tree is balanced
public boolean isBalanced(TreeNode root) {
   return checkHeight(root) != -1;
}

// Helper function to check the height and balance of the tree
private int checkHeight(TreeNode node) {
   if (node == null) {
       return 0;
   }

   // Check the height of the left subtree
   int leftHeight = checkHeight(node.left);
   if (leftHeight == -1) {
       return -1;
   }

   // Check the height of the right subtree
   int rightHeight = checkHeight(node.right);
   if (rightHeight == -1) {
       return -1;
   }

   // If the height difference is more than 1, the tree is not balanced
   if (Math.abs(leftHeight - rightHeight) > 1) {
       return -1;
   }

   // Return the height of the tree
   return Math.max(leftHeight, rightHeight) + 1;
}

public static void main(String[] args) {
   // Example usage
   BalancedBinaryTree tree = new BalancedBinaryTree();

   // Creating a balanced binary tree
   TreeNode root = new TreeNode(1);
   root.left = new TreeNode(2);
   root.right = new TreeNode(3);
   root.left.left = new TreeNode(4);
   root.left.right = new TreeNode(5);
   root.right.right = new TreeNode(6);

   System.out.println("Is the tree balanced? " + tree.isBalanced(root)); // Output: true

   // Creating an unbalanced binary tree
   TreeNode unbalancedRoot = new TreeNode(1);
   unbalancedRoot.left = new TreeNode(2);
   unbalancedRoot.left.left = new TreeNode(3);

   System.out.println("Is the tree balanced? " + tree.isBalanced(unbalancedRoot)); // Output: false
}
}


