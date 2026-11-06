import java.util.Scanner;

public class Question1 {
    static class Node {
        int data;
        Node next, prev;
        Node(int data) { this.data = data; }
    }

    static class DoublyList {
        Node head;
        void insertFirst(int x) {
            Node n = new Node(x); n.next = head;
            if (head != null) head.prev = n;
            head = n;
        }
        void insertLast(int x) {
            Node n = new Node(x);
            if (head == null) { head = n; return; }
            Node t = head; while (t.next != null) t = t.next;
            t.next = n; n.prev = t;
        }
        boolean insertBefore(int key, int x) {
            Node t = find(key); if (t == null) return false;
            if (t == head) { insertFirst(x); return true; }
            Node n = new Node(x), p = t.prev;
            p.next = n; n.prev = p; n.next = t; t.prev = n; return true;
        }
        boolean insertAfter(int key, int x) {
            Node t = find(key); if (t == null) return false;
            Node n = new Node(x), q = t.next;
            t.next = n; n.prev = t; n.next = q;
            if (q != null) q.prev = n; return true;
        }
        Node find(int x) { for (Node t=head; t!=null; t=t.next) if(t.data==x) return t; return null; }
        boolean delete(int x) {
            Node t = find(x); if(t==null) return false;
            if(t.prev!=null) t.prev.next=t.next; else head=t.next;
            if(t.next!=null) t.next.prev=t.prev;
            return true;
        }
        void display() {
            if(head==null) { System.out.println("List is empty."); return; }
            for(Node t=head;t!=null;t=t.next) System.out.print(t.data+" <-> ");
            System.out.println("NULL");
        }
    }

    static class CircularList {
        Node head;
        void insertFirst(int x) {
            Node n=new Node(x);
            if(head==null) { head=n; n.next=n; return; }
            Node last=head; while(last.next!=head) last=last.next;
            n.next=head; last.next=n; head=n;
        }
        void insertLast(int x) {
            Node n=new Node(x);
            if(head==null) { head=n; n.next=n; return; }
            Node last=head; while(last.next!=head) last=last.next;
            last.next=n; n.next=head;
        }
        boolean insertBefore(int key,int x) {
            if(head==null) return false;
            if(head.data==key) { insertFirst(x); return true; }
            Node p=head, t=head.next;
            while(t!=head && t.data!=key) { p=t; t=t.next; }
            if(t==head) return false;
            Node n=new Node(x); p.next=n; n.next=t; return true;
        }
        boolean insertAfter(int key,int x) {
            Node t=find(key); if(t==null) return false;
            Node n=new Node(x); n.next=t.next; t.next=n; return true;
        }
        Node find(int x) {
            if(head==null) return null;
            Node t=head; do { if(t.data==x) return t; t=t.next; } while(t!=head);
            return null;
        }
        boolean delete(int x) {
            if(head==null) return false;
            Node t=head, p=null;
            do {
                if(t.data==x) {
                    if(t==head && t.next==head) head=null;
                    else {
                        if(p==null) { Node last=head; while(last.next!=head) last=last.next; head=head.next; last.next=head; }
                        else p.next=t.next;
                    }
                    return true;
                }
                p=t; t=t.next;
            } while(t!=head);
            return false;
        }
        void display() {
            if(head==null) { System.out.println("List is empty."); return; }
            Node t=head; do { System.out.print(t.data+" -> "); t=t.next; } while(t!=head);
            System.out.println("(back to head)");
        }
    }

    static int readInt(Scanner sc, String prompt) {
        System.out.print(prompt); return sc.nextInt();
    }
    static void operateDoubly(Scanner sc, DoublyList list) {
        while(true) {
            System.out.println("\\nDLL: 1 Insert first  2 Insert last  3 Insert before  4 Insert after  5 Delete value  6 Search  7 Display  0 Back");
            int c=readInt(sc,"Choice: ");
            if(c==0) return;
            int x,key;
            switch(c) {
                case 1: list.insertFirst(readInt(sc,"Value: ")); break;
                case 2: list.insertLast(readInt(sc,"Value: ")); break;
                case 3: key=readInt(sc,"Insert before which value? "); x=readInt(sc,"New value: "); System.out.println(list.insertBefore(key,x)?"Inserted.":"Value not found."); break;
                case 4: key=readInt(sc,"Insert after which value? "); x=readInt(sc,"New value: "); System.out.println(list.insertAfter(key,x)?"Inserted.":"Value not found."); break;
                case 5: System.out.println(list.delete(readInt(sc,"Delete value: "))?"Deleted.":"Value not found."); break;
                case 6: System.out.println(list.find(readInt(sc,"Search value: "))!=null?"Found.":"Not found."); break;
                case 7: list.display(); break;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    static void operateCircular(Scanner sc, CircularList list) {
        while(true) {
            System.out.println("\\nCLL: 1 Insert first  2 Insert last  3 Insert before  4 Insert after  5 Delete value  6 Search  7 Display  0 Back");
            int c=readInt(sc,"Choice: ");
            if(c==0) return;
            int x,key;
            switch(c) {
                case 1: list.insertFirst(readInt(sc,"Value: ")); break;
                case 2: list.insertLast(readInt(sc,"Value: ")); break;
                case 3: key=readInt(sc,"Insert before which value? "); x=readInt(sc,"New value: "); System.out.println(list.insertBefore(key,x)?"Inserted.":"Value not found."); break;
                case 4: key=readInt(sc,"Insert after which value? "); x=readInt(sc,"New value: "); System.out.println(list.insertAfter(key,x)?"Inserted.":"Value not found."); break;
                case 5: System.out.println(list.delete(readInt(sc,"Delete value: "))?"Deleted.":"Value not found."); break;
                case 6: System.out.println(list.find(readInt(sc,"Search value: "))!=null?"Found.":"Not found."); break;
                case 7: list.display(); break;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DoublyList dll=new DoublyList(); CircularList cll=new CircularList();
        while(true) {
            System.out.println("\\nMAIN MENU: 1 Doubly Linked List  2 Circular Linked List  0 Exit");
            int c=readInt(sc,"Choice: ");
            if(c==0) break;
            if(c==1) operateDoubly(sc,dll);
            else if(c==2) operateCircular(sc,cll);
            else System.out.println("Invalid choice.");
        }
        sc.close();
    }
}
