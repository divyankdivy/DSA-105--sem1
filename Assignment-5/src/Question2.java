import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LinkedList list = new LinkedList();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter linked list elements:");

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.insertEnd(data);
        }

        System.out.print("Enter key: ");
        int key = sc.nextInt();

        System.out.print("Original Linked List: ");
        list.display();

        int count = list.countAndDelete(key);

        System.out.println("Count: " + count);

        System.out.print("Updated Linked List: ");
        list.display();

        sc.close();
    }
}