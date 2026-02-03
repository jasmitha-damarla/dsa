package BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    
    public int search(int[] nums, int target) {
        int h = nums.length - 1;
        int l = 0;
        while(l <= h) {
            int mid = (h + l) / 2; // l + (h - l) / 2
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return -1;

        // Built-in function
        // int index = Arrays.binarySearch(nums, target);
        // return index >= 0 ? index : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(arr, k));
    }
}
