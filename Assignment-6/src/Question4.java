import java.util.Scanner;

public class Question4 {
    static class Node { char data; Node next,prev; Node(char c){data=c;} }
    static boolean isPalindrome(Node head) {
        if(head==null) return true;
        Node left=head,right=head;
        while(right.next!=null) right=right.next;
        while(left!=right && left.prev!=right) {
            if(left.data!=right.data) return false;
            left=left.next; right=right.prev;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter characters (without spaces): ");
        String s=sc.next();
        Node head=null,tail=null;
        for(char c:s.toCharArray()) {
            Node x=new Node(c);
            if(head==null) head=x; else {tail.next=x; x.prev=tail;}
            tail=x;
        }
        System.out.println(isPalindrome(head)?"True":"False");
        sc.close();
    }
}
