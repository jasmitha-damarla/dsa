package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class ReOrderList {
    
    public void reorderList(ListNode head) {
        ListNode s = head, f = head.next;
        while(f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }
        ListNode sh = s.next;
        ListNode prev = s.next = null;
        while(sh != null) {
            ListNode t = sh.next;
            sh.next = prev;
            prev = sh;
            sh = t;
        }
        ListNode fh = head;
        sh = prev;
        while(sh !=null) {
            ListNode t1 = fh.next;
            ListNode t2 = sh.next;
            fh.next = sh;
            sh.next = t1;
            fh = t1;
            sh = t2;
        }
    }

    public static void main(String[] args) {
        
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = null;
        
        ListNode h = first;
        while(h != null) {
            System.out.println(h.val);
            h = h.next;
        }

        ReOrderList reOrderList = new ReOrderList();
        reOrderList.reorderList(first);
        while(first != null) {
            System.out.println(first.val);
            first = first.next;
        }
    }
}
