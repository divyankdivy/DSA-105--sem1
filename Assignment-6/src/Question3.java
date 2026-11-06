import java.util.Scanner;

public class Question3 {
    static class DNode { int data; DNode next,prev; DNode(int d){data=d;} }
    static class CNode { int data; CNode next; CNode(int d){data=d;} }
    static int doublySize(DNode head) {
        int count=0; for(DNode t=head;t!=null;t=t.next) count++; return count;
    }
    static int circularSize(CNode head) {
        if(head==null) return 0;
        int count=0; CNode t=head;
        do { count++; t=t.next; } while(t!=head);
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Number of DLL nodes: "); int n=sc.nextInt();
        DNode dh=null,dt=null;
        for(int i=0;i<n;i++) {
            DNode x=new DNode(sc.nextInt());
            if(dh==null) dh=x; else {dt.next=x; x.prev=dt;} dt=x;
        }
        System.out.print("Number of CLL nodes: "); int m=sc.nextInt();
        CNode ch=null,ct=null;
        for(int i=0;i<m;i++) {
            CNode x=new CNode(sc.nextInt());
            if(ch==null) ch=x; else ct.next=x; ct=x;
        }
        if(ct!=null) ct.next=ch;
        System.out.println("Size of Doubly Linked List = "+doublySize(dh));
        System.out.println("Size of Circular Linked List = "+circularSize(ch));
        sc.close();
    }
}
