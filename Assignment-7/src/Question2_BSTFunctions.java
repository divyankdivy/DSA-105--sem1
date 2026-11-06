/**
 * Question 2: Binary Search Tree Functions
 * (a) Search (Recursive & Non-Recursive)
 * (b) Max element
 * (c) Min element
 * (d) In-order successor
 * (e) In-order predecessor
 */
public class Question2_BSTFunctions {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // (a) Search - Recursive Approach
    public static Node searchRecursive(Node root, int key) {
        if (root == null || root.data == key) return root;
        if (key < root.data) return searchRecursive(root.left, key);
        return searchRecursive(root.right, key);
    }

    // (a) Search - Non-Recursive (Iterative) Approach
    public static Node searchIterative(Node root, int key) {
        Node curr = root;
        while (curr != null) {
            if (curr.data == key) return curr;
            if (key < curr.data) curr = curr.left;
            else curr = curr.right;
        }
        return null;
    }

    // (b) Maximum Element of the BST
    public static Node findMax(Node root) {
        if (root == null) return null;
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    // (c) Minimum Element of the BST
    public static Node findMin(Node root) {
        if (root == null) return null;
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    // (d) In-order Successor of a given node
    public static Node inOrderSuccessor(Node root, Node target) {
        if (target == null) return null;

        // Case 1: If right subtree exists, successor is minimum node in right subtree
        if (target.right != null) {
            return findMin(target.right);
        }

        // Case 2: Travel from root to target to find deepeset ancestor for which target is in left subtree
        Node successor = null;
        Node curr = root;
        while (curr != null) {
            if (target.data < curr.data) {
                successor = curr;
                curr = curr.left;
            } else if (target.data > curr.data) {
                curr = curr.right;
            } else {
                break;
            }
        }
        return successor;
    }

    // (e) In-order Predecessor of a given node
    public static Node inOrderPredecessor(Node root, Node target) {
        if (target == null) return null;

        // Case 1: If left subtree exists, predecessor is maximum node in left subtree
        if (target.left != null) {
            return findMax(target.left);
        }

        // Case 2: Travel from root to target to find deepest ancestor for which target is in right subtree
        Node predecessor = null;
        Node curr = root;
        while (curr != null) {
            if (target.data > curr.data) {
                predecessor = curr;
                curr = curr.right;
            } else if (target.data < curr.data) {
                curr = curr.left;
            } else {
                break;
            }
        }
        return predecessor;
    }

    // Helper method to insert nodes into BST
    public static Node insert(Node root, int key) {
        if (root == null) return new Node(key);
        if (key < root.data) root.left = insert(root.left, key);
        else if (key > root.data) root.right = insert(root.right, key);
        return root;
    }

    public static void main(String[] args) {
        /*
                 50
               /    \
             30      70
            /  \    /  \
          20   40  60   80
        */
        Node root = null;
        int[] keys = {50, 30, 70, 20, 40, 60, 80};
        for (int k : keys) root = insert(root, k);

        System.out.println("--- SEARCH TESTS ---");
        System.out.println("Search 40 (Recursive): " + (searchRecursive(root, 40) != null ? "Found" : "Not Found"));
        System.out.println("Search 90 (Iterative): " + (searchIterative(root, 90) != null ? "Found" : "Not Found"));

        System.out.println("\n--- MIN & MAX TESTS ---");
        System.out.println("Min Element: " + findMin(root).data);
        System.out.println("Max Element: " + findMax(root).data);

        System.out.println("\n--- SUCCESSOR & PREDECESSOR TESTS ---");
        Node targetNode = searchRecursive(root, 40);
        Node succ = inOrderSuccessor(root, targetNode);
        Node pred = inOrderPredecessor(root, targetNode);

        System.out.println("Target Node: " + targetNode.data);
        System.out.println("In-order Successor of 40:   " + (succ != null ? succ.data : "None"));
        System.out.println("In-order Predecessor of 40: " + (pred != null ? pred.data : "None"));
    }
}
