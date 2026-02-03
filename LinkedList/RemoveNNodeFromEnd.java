package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int N = 0;
        while(cur != null) {
            cur = cur.next;
            N++;
        }
        int t = N - n;
        if(t == 0) {
            return head.next;
        }
        int c = 0;
        cur = head;
        while(c < N - 1) {
            if(c == t - 1) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
            c++;
        } 
        return head;
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
        int n = 1;

        RemoveNNodeFromEnd removeNNodeFromEnd = new RemoveNNodeFromEnd();
        ListNode res = removeNNodeFromEnd.removeNthFromEnd(first, n);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
    
}
