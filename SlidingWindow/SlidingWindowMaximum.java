package SlidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0, N = nums.length, p = 0, r = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        int[] slideWindow = new int[N - k + 1];
        while(r < N) {
            while(!deque.isEmpty() && nums[deque.getLast()] < nums[r]){
                deque.removeLast();
            }

            deque.addLast(r);

            if(l > deque.getFirst()) {
                deque.removeFirst();
            }

            if(r + 1 >= k){
                slideWindow[p] = nums[deque.getFirst()];
                p++;
                l++;
            }
            r++;
        }
        return slideWindow;
    }
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(slidingWindowMaximum.maxSlidingWindow(arr, k)));
    }
}
