package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int r = 0;
        ListNode sol = new ListNode(0);
        ListNode t = sol;
        while(l1 != null || l2 != null) {
            int f = 0, s = 0;
            if(l1 != null) {
                f = l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                s = l2.val;
                l2 = l2.next;
            }
            int cur = f + s + r;
            if(cur > 9){
                r = cur / 10;
                cur = cur % 10;
            } else {
                r = 0;
            }
            sol.next = new ListNode(cur);
            sol = sol.next;
        }
        if(r > 0){
            sol.next = new ListNode(r);
        }
        return t.next;
    }
    
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = null;
        
        ListNode sfirst = new ListNode(3);
        ListNode ssecond = new ListNode(9);
        ListNode sthird = new ListNode(5);
        sfirst.next = ssecond;
        ssecond.next = sthird;
        sthird.next = null;

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode head = addTwoNumbers.addTwoNumbers(first, sfirst);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
