package Stack;

import java.util.Scanner;
import java.util.Stack;

public class LargestRectangleArea {

    public int largestRectangleArea(int[] heights) {
        int maxArea = 0, N = heights.length;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= N; i++) {
            while(!stack.isEmpty() && (i == N || heights[stack.peek()] >= heights[i])) {
                int ht = heights[stack.pop()];
                int wd = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, ht * wd);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(arr));
    }
}
