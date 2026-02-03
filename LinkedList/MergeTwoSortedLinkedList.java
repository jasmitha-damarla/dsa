package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeTwoSortedLinkedList {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p = new ListNode(0);
        ListNode res = p;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                p.next = list1;
                list1 = list1.next;
            } else {
                p.next = list2;
                list2 = list2.next;
            }
            p = p.next;
        }
        if (list1 != null) {
            p.next = list1;
        } else {
            p.next = list2;
        }
        return res.next;
    }
    
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = null;
        
        ListNode sfirst = new ListNode(2);
        ListNode ssecond = new ListNode(4);
        ListNode sthird = new ListNode(5);
        sfirst.next = ssecond;
        ssecond.next = sthird;
        sthird.next = null;

        MergeTwoSortedLinkedList mergeTwoSortedLinkedList = new MergeTwoSortedLinkedList();
        ListNode head = mergeTwoSortedLinkedList.mergeTwoLists(first, sfirst);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
