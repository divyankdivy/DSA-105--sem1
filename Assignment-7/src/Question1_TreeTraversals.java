/**
 * Question 1: Binary Tree Traversals (Recursive Approach)
 * Lab Assignment 8: BST & Heap
 */
public class Question1_TreeTraversals {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Pre-order Traversal: Root -> Left -> Right
    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // In-order Traversal: Left -> Root -> Right
    public static void inOrder(Node root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    // Post-order Traversal: Left -> Right -> Root
    public static void postOrder(Node root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        /* Constructing binary tree:
                 1
                / \
               2   3
              / \
             4   5
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Pre-order Traversal:  ");
        preOrder(root);
        System.out.println();

        System.out.print("In-order Traversal:   ");
        inOrder(root);
        System.out.println();

        System.out.print("Post-order Traversal: ");
        postOrder(root);
        System.out.println();
    }
}
