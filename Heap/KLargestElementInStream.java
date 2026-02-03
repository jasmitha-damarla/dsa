package Heap;

import java.util.PriorityQueue;

public class KLargestElementInStream {

    PriorityQueue<Integer> minHeap;
    int k;

    public KLargestElementInStream(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<Integer>();
        for(int num: nums) {8
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if(minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
    
    public static void main(String[] args) {

        KLargestElementInStream kLargestElementInStream = new KLargestElementInStream(3, new int[] {1, 2, 3, 3});
        System.out.println(kLargestElementInStream.add(3));
        System.out.println(kLargestElementInStream.add(4));
        System.out.println(kLargestElementInStream.add(5));
        System.out.println(kLargestElementInStream.add(6));
        System.out.println(kLargestElementInStream.add(7));

    }
}
