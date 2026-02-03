package Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[0] * b[0] + b[1] * b[1],
                                      a[0] * a[0] + a[1] * a[1])
        );
        for(int[] point: points) {
            maxHeap.offer(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[][] sol = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()) {
            sol[i++] = maxHeap.poll();
        }
        return sol;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        for (int[] point : kClosestPointsToOrigin.kClosest(new int[][]{{0,2},{2,0},{2,2}}, 2)) {
            System.out.println(Arrays.toString(point));
        }
    }
    
}
