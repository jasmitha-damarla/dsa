package BinarySearch;

import java.util.Scanner;

public class MinElementInRotatedArray {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int m = l + (r - l) / 2;
            if(nums[m] > nums[r]) {
                l = m + 1;
            } else {
                r = m;
            } 
        }
        return nums[l];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        MinElementInRotatedArray minElementInRotatedArray = new MinElementInRotatedArray();
        System.out.println(minElementInRotatedArray.findMin(arr));
    }
    
}
