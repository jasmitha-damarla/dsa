package LinkedList;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode cur = null, n = null;
        while(head != null) {
            n = head.next;
            head.next = cur;
            cur = head;
            head = n;
        }
        return cur;
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

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = reverseLinkedList.reverseList(first);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
