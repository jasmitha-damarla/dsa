package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class DetectCycle {

    public boolean hasCycle(ListNode head) {
        // if(head.next == null || head.next.next == null) {
        //     return false;
        // }
        ListNode s = head, f = head;
        while(f!=null && f.next!=null) {
            s = s.next;
            f = f.next.next;
            if(s == f) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode second = new ListNode(2);
        ListNode first = new ListNode(1);
        ListNode third = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = first;

        DetectCycle detectCycle = new DetectCycle();
        System.out.println(detectCycle.hasCycle(first) ? "Yes" : "No");
    }
}
