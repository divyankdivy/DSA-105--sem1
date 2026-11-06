/**
 * Question 3: BST Operations
 * (a) Insert an element (no duplicates allowed)
 * (b) Delete an existing element
 * (c) Maximum depth of BST
 * (d) Minimum depth of BST
 */
public class Question3_BSTOperations {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // (a) Insert an element (no duplicates allowed)
    public static Node insert(Node root, int val) {
        if (root == null) return new Node(val);
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }
        // Duplicate values are ignored
        return root;
    }

    // Helper method to find minimum value node in a subtree
    private static int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    // (b) Delete an existing element
    public static Node delete(Node root, int val) {
        if (root == null) return null;

        if (val < root.data) {
            root.left = delete(root.left, val);
        } else if (val > root.data) {
            root.right = delete(root.right, val);
        } else {
            // Node to be deleted found

            // Case 1 & 2: Node with zero or one child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // Case 3: Node with two children
            root.data = minValue(root.right);
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    // (c) Maximum depth of BST
    public static int maxDepth(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // (d) Minimum depth of BST
    public static int minDepth(Node root) {
        if (root == null) return 0;

        if (root.left == null) return 1 + minDepth(root.right);
        if (root.right == null) return 1 + minDepth(root.left);

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }

    public static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int[] vals = {15, 10, 20, 8, 12, 18, 25};

        System.out.println("Inserting elements: 15, 10, 20, 8, 12, 18, 25");
        for (int v : vals) root = insert(root, v);

        // Attempting to insert a duplicate
        root = insert(root, 10); // Duplicate ignored

        System.out.print("In-order Traversal: ");
        inOrder(root);
        System.out.println();

        System.out.println("Maximum Depth: " + maxDepth(root));
        System.out.println("Minimum Depth: " + minDepth(root));

        System.out.println("\nDeleting node 10...");
        root = delete(root, 10);

        System.out.print("In-order Traversal after deletion: ");
        inOrder(root);
        System.out.println();
        System.out.println("Maximum Depth after deletion: " + maxDepth(root));
    }
}
