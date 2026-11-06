class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    Node head = null;

    // (a) Insertion at beginning
    void insertBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        System.out.println("Node inserted at beginning.");
    }

    // (b) Insertion at end
    void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        System.out.println("Node inserted at end.");
    }

    // (c) Insertion before a specific node
    void insertBefore(int key, int data) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == key) {
            insertBeginning(data);
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Node not found.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // (c) Insertion after a specific node
    void insertAfter(int key, int data) {
        Node temp = head;

        while (temp != null && temp.data != key) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Node not found.");
            return;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // (d) Deletion from beginning
    void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        head = head.next;
        System.out.println("First node deleted.");
    }

    // (e) Deletion from end
    void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
        System.out.println("Last node deleted.");
    }

    // (f) Deletion of a specific node
    void deleteSpecific(int key) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;

        while (temp.next != null && temp.next.data != key) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Node not found.");
            return;
        }

        temp.next = temp.next.next;
        System.out.println("Node deleted.");
    }

    // (g) Search a node and display position
    void search(int key) {
        Node temp = head;
        int position = 1;

        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Node found at position: " + position);
                return;
            }

            temp = temp.next;
            position++;
        }

        System.out.println("Node not found.");
    }

    // (h) Display all nodes
    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("NULL");
    }

//    Question2
    // Count occurrences and delete all occurrences
    int countAndDelete(int key) {
        int count = 0;

        // Delete occurrences from beginning
        while (head != null && head.data == key) {
            head = head.next;
            count++;
        }

        // Delete occurrences from remaining list
        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.next.data == key) {
                temp.next = temp.next.next;
                count++;
            } else {
                temp = temp.next;
            }
        }

        return count;
    }

    // Find middle element of linked list
    void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        System.out.println("Middle Element: " + slow.data);
    }

    // Reverse the linked list
    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

        System.out.println("Linked List reversed successfully.");
    }
}