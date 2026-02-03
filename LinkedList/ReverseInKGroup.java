package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ReverseInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpNode = new ListNode(0, head);
        ListNode prevGroup = dumpNode;
        while(true) {
            ListNode kNode = getKNode(prevGroup, k);
            if(kNode == null) {
                break;
            }

            ListNode nextGroup = kNode.next;
            ListNode prev = kNode.next;
            ListNode cur = prevGroup.next;
            while(cur != nextGroup) {
                ListNode tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            }

            ListNode tmp = prevGroup.next;
            prevGroup.next = kNode;
            prevGroup = tmp;

        }

        return dumpNode.next;
    }

    public ListNode getKNode(ListNode cur, int k) {
        while(cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }
}
