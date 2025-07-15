package BinarySearch;

import java.util.Scanner;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r) {
            int m = l + (r - l) / 2;
            if(nums[m] == target) {
                return m;
            } else if(nums[l] <= nums[m]) {
                if(nums[m] < target || nums[l] > target) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                if(nums[m] > target || nums[r] < target) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }
        }    
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        System.out.println(searchInRotatedSortedArray.search(arr, k));
    }
    
}
