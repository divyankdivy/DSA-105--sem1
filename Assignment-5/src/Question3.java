import java.util.Scanner;

public class Question3 {
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

        System.out.print("Linked List: ");
        list.display();

        list.findMiddle();

        sc.close();
    }
}