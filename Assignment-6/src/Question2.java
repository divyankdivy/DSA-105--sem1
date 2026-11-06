import java.util.Scanner;

public class Question2 {
    static class Node { int data; Node next; Node(int d){data=d;} }
    static void display(Node head) {
        if(head==null) { System.out.println("List is empty."); return; }
        Node current=head;
        do { System.out.print(current.data+" "); current=current.next; } while(current!=head);
        System.out.println(head.data);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of nodes: "); int n=sc.nextInt();
        Node head=null, tail=null;
        for(int i=0;i<n;i++) {
            System.out.print("Value: "); Node node=new Node(sc.nextInt());
            if(head==null) head=node; else tail.next=node;
            tail=node;
        }
        if(tail!=null) tail.next=head;
        display(head);
        sc.close();
    }
}
