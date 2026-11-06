import java.util.Scanner;

public class Question5 {
    static class Node { int data; Node next; Node(int d){data=d;} }
    // Floyd's cycle detection: true only if traversal returns to the head.
    static boolean isCircular(Node head) {
        if(head==null) return false;
        Node slow=head,fast=head;
        do {
            if(fast==null || fast.next==null) return false;
            slow=slow.next; fast=fast.next.next;
        } while(slow!=fast);
        return slow==head;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of nodes: "); int n=sc.nextInt();
        Node head=null,tail=null;
        for(int i=0;i<n;i++) {
            Node x=new Node(sc.nextInt());
            if(head==null) head=x; else tail.next=x;
            tail=x;
        }
        System.out.print("Make last node point to head? (true/false): ");
        boolean circular=sc.nextBoolean();
        if(circular && tail!=null) tail.next=head;
        System.out.println(isCircular(head)?"True":"False");
        sc.close();
    }
}
