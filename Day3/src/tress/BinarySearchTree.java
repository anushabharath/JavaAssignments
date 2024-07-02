package tress;

//Class to represent a node in the BST
class Node {
 int data;
 Node left, right;

 public Node(int item) {
     data = item;
     left = right = null;
 }
}

//Class to represent the BST
class BinarySearchTree {
 Node root;

 BinarySearchTree() {
     root = null;
 }

 // Method to insert a new node in the BST
 void insert(int data) {
     root = insertRec(root, data);
 }

 // A recursive function to insert a new node in the BST
 Node insertRec(Node root, int data) {
     // If the tree is empty, return a new node
     if (root == null) {
         root = new Node(data);
         return root;
     }

     // Otherwise, recur down the tree
     if (data < root.data)
         root.left = insertRec(root.left, data);
     else if (data > root.data)
         root.right = insertRec(root.right, data);

     // Return the (unchanged) node pointer
     return root;
 }

 // Method to do preorder traversal of BST
 void preorder() {
     preorderRec(root);
     System.out.println();
 }

 // A recursive function to do preorder traversal of BST
 void preorderRec(Node root) {
     if (root != null) {
         // Visit the root node
         System.out.print(root.data + " ");
         // Recur on the left subtree
         preorderRec(root.left);
         // Recur on the right subtree
         preorderRec(root.right);
     }
 }

 // Method to do inorder traversal of BST
 void inorder() {
     inorderRec(root);
     System.out.println();
 }

 // A recursive function to do inorder traversal of BST
 void inorderRec(Node root) {
     if (root != null) {
         // Recur on the left subtree
         inorderRec(root.left);
         // Visit the root node
         System.out.print(root.data + " ");
         // Recur on the right subtree
         inorderRec(root.right);
     }
 }

 // Method to do postorder traversal of BST
 void postorder() {
     postorderRec(root);
     System.out.println();
 }

 // A recursive function to do postorder traversal of BST
 void postorderRec(Node root) {
     if (root != null) {
         // Recur on the left subtree
         postorderRec(root.left);
         // Recur on the right subtree
         postorderRec(root.right);
         // Visit the root node
         System.out.print(root.data + " ");
     }
 }

 public static void main(String[] args) {
     BinarySearchTree tree = new BinarySearchTree();

     // Insert nodes into the BST
     int[] nodes = {50, 30, 20, 40, 70, 60, 80};
     for (int node : nodes) {
         tree.insert(node);
     }

     // Print traversals of the BST
     System.out.println("Preorder traversal of the binary search tree:");
     tree.preorder();

     System.out.println("Inorder traversal of the binary search tree:");
     tree.inorder();

     System.out.println("Postorder traversal of the binary search tree:");
     tree.postorder();
 }
}


