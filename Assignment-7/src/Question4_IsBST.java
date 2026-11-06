/**
 * Question 4: Determine whether a given binary tree is a BST or not.
 */
public class Question4_IsBST {

    static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Function to check if tree is BST
    public static boolean isBST(Node root) {
        return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean isBSTUtil(Node node, long min, long max) {
        if (node == null) return true;

        // If node value violates min/max constraint
        if (node.data <= min || node.data >= max) return false;

        // Subtrees must satisfy updated min/max constraints
        return isBSTUtil(node.left, min, node.data) &&
               isBSTUtil(node.right, node.data, max);
    }

    public static void main(String[] args) {
        /*
           Tree 1 (Valid BST):
                 4
               /   \
              2     5
             / \
            1   3
        */
        Node root1 = new Node(4);
        root1.left = new Node(2);
        root1.right = new Node(5);
        root1.left.left = new Node(1);
        root1.left.right = new Node(3);

        System.out.println("Tree 1 is a BST: " + isBST(root1));

        /*
           Tree 2 (Invalid BST):
                 4
               /   \
              2     5
               \
                6   (Violates BST rule: 6 > 4 in left subtree)
        */
        Node root2 = new Node(4);
        root2.left = new Node(2);
        root2.right = new Node(5);
        root2.left.right = new Node(6);

        System.out.println("Tree 2 is a BST: " + isBST(root2));
    }
}
