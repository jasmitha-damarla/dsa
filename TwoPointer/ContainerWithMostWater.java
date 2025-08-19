package TwoPointer;

import java.util.Scanner;

public class ContainerWithMostWater {

    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1, maxArea = 0;
        while ( l < r) {
            int area = (r - l) * Math.min(heights[l], heights[r]);
            maxArea = Math.max(maxArea, area);
            if(heights[l] <= heights[r]){
                l++;
            } else if(heights[l] > heights[r]) {
                r--;
            } 
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
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(arr));
    }
}
