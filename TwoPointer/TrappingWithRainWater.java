package TwoPointer;

import java.util.Scanner;

public class TrappingWithRainWater {

    public int trap(int[] height) {
        int trw = 0, l = 0, r = height.length - 1, lm = 0, rm = 0;
        while( l < r) {
            if(height[l] <= height[r]){
                lm = Math.max(lm, height[l]);
                trw += lm - height[l];
                l++;
            } else {
                rm = Math.max(rm, height[r]);
                trw += rm - height[r];
                r--;
            }
        }
        return trw;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        TrappingWithRainWater trappingWithRainWater = new TrappingWithRainWater();
        System.out.println(trappingWithRainWater.trap(arr));
    }
}
