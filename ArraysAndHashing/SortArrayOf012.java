package ArraysAndHashing;

import java.util.Arrays;

public class SortArrayOf012 {

    private void swap(int[] nums, int x, int y) {
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }

    public void sortZeroOneTwo(int[] nums) {
        int N = nums.length;
        int low = 0, mid = 0, high = N - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        SortArrayOf012 sol = new SortArrayOf012();

        // Test case 1: Standard Dutch National Flag
        int[] nums1 = { 1, 0, 2, 1, 0, 2, 1 };
        System.out.println("Before: " + Arrays.toString(nums1));
        sol.sortZeroOneTwo(nums1);
        System.out.println("After:  " + Arrays.toString(nums1)); // [0,0,1,1,1,2,2]
        System.out.println();

        // Test case 2: Already sorted
        int[] nums2 = { 0, 0, 1, 1, 2, 2 };
        System.out.println("Before: " + Arrays.toString(nums2));
        sol.sortZeroOneTwo(nums2);
        System.out.println("After:  " + Arrays.toString(nums2)); // [0,0,1,1,2,2]
        System.out.println();

        // Test case 3: All same values
        int[] nums3 = { 1, 1, 1, 1 };
        System.out.println("Before: " + Arrays.toString(nums3));
        sol.sortZeroOneTwo(nums3);
        System.out.println("After:  " + Arrays.toString(nums3)); // [1,1,1,1]
        System.out.println();

        // Test case 4: Small array
        int[] nums4 = { 2, 0, 1 };
        System.out.println("Before: " + Arrays.toString(nums4));
        sol.sortZeroOneTwo(nums4);
        System.out.println("After:  " + Arrays.toString(nums4)); // [0,1,2]
        System.out.println();

        // Test case 5: Worst case
        int[] nums5 = { 2, 2, 2, 0, 0, 1, 1 };
        System.out.println("Before: " + Arrays.toString(nums5));
        sol.sortZeroOneTwo(nums5);
        System.out.println("After:  " + Arrays.toString(nums5)); // [0,0,1,1,2,2,2]
    }
}
