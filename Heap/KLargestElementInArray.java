package Heap;

import java.util.PriorityQueue;

public class KLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
    
    public static void main(String[] args) {
        KLargestElementInArray kLargestElementInArray = new KLargestElementInArray();
        System.out.println(kLargestElementInArray.findKthLargest(new int[]{2,3,1,5,4}, 2));
    }
}
