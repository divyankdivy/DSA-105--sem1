import java.util.Scanner;

public class Question1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        int choice, data, key;

        do {
            System.out.println("\n----- SINGLY LINKED LIST MENU -----");
            System.out.println("1. Insertion at Beginning");
            System.out.println("2. Insertion at End");
            System.out.println("3. Insertion Before a Node");
            System.out.println("4. Insertion After a Node");
            System.out.println("5. Deletion from Beginning");
            System.out.println("6. Deletion from End");
            System.out.println("7. Deletion of Specific Node");
            System.out.println("8. Search a Node");
            System.out.println("9. Display Linked List");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertBeginning(data);
                    break;

                case 2:
                    System.out.print("Enter data: ");
                    data = sc.nextInt();
                    list.insertEnd(data);
                    break;

                case 3:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();

                    System.out.print("Insert before which node: ");
                    key = sc.nextInt();

                    list.insertBefore(key, data);
                    break;

                case 4:
                    System.out.print("Enter data to insert: ");
                    data = sc.nextInt();

                    System.out.print("Insert after which node: ");
                    key = sc.nextInt();

                    list.insertAfter(key, data);
                    break;

                case 5:
                    list.deleteBeginning();
                    break;

                case 6:
                    list.deleteEnd();
                    break;

                case 7:
                    System.out.print("Enter node value to delete: ");
                    key = sc.nextInt();
                    list.deleteSpecific(key);
                    break;

                case 8:
                    System.out.print("Enter value to search: ");
                    key = sc.nextInt();
                    list.search(key);
                    break;

                case 9:
                    System.out.print("Linked List: ");
                    list.display();
                    break;

                case 0:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}