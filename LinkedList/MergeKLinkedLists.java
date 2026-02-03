package LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class MergeKLinkedLists {

    // Heap

    // public ListNode mergeKListsHeap(ListNode[] lists) {
    //     if (lists.length == 0) return null;

    //     PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
    //     for (ListNode list : lists) {
    //         if (list != null) {
    //             minHeap.offer(list);
    //         }
    //     }

    //     ListNode res = new ListNode(0);
    //     ListNode cur = res;
    //     while (!minHeap.isEmpty()) {
    //         ListNode node = minHeap.poll();
    //         cur.next = node;
    //         cur = cur.next;

    //         node = node.next;
    //         if (node != null) {
    //             minHeap.offer(node);
    //         }
    //     }
    //     return res.next;
    // }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }
        MergeTwoSortedLinkedList mergeTwoSortedLinkedList = new MergeTwoSortedLinkedList();
        
        while(lists.length > 1) {
            List<ListNode> mergedListNode = new ArrayList<>();
            for(int i = 0; i < lists.length; i+=2) {
                ListNode firstListNode = lists[i];
                ListNode secondListNode = (i + 1) < lists.length ? lists[i + 1] : null;
                mergedListNode.add(mergeTwoSortedLinkedList.mergeTwoLists(firstListNode, secondListNode));
            }
            lists = (ListNode[]) mergedListNode.toArray(new ListNode[0]);
        }
        return lists[0];
    }

}
