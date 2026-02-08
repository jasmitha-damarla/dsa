package ArraysAndHashing;

import java.util.Arrays;

public class MaximumSubArraySum {

    public int maxSubArray(int[] nums) {
        int curSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            if (curSum > maxSum) {
                maxSum = curSum;
            }
            if (curSum < 0) {
                curSum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSubArraySum sol = new MaximumSubArraySum();

        // Test case 1: Mixed positive and negative
        int[] nums1 = { 1, 2, 3, -2, 5 };
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("Max subarray sum: " + sol.maxSubArray(nums1)); // 9 ([1,2,3,-2,5])
        System.out.println();

        // Test case 2: All negative
        int[] nums2 = { -2, -3, -1, -4 };
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Max subarray sum: " + sol.maxSubArray(nums2)); // -1 ([-1])
        System.out.println();

        // Test case 3: All positive
        int[] nums3 = { 5, 4, 1, 7, 8 };
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("Max subarray sum: " + sol.maxSubArray(nums3)); // 25 (entire array)
        System.out.println();

        // Test case 4: Single element
        int[] nums4 = { 3 };
        System.out.println("nums4: " + Arrays.toString(nums4));
        System.out.println("Max subarray sum: " + sol.maxSubArray(nums4)); // 3
        System.out.println();

        // Test case 5: Alternating signs
        int[] nums5 = { 2, -1, 2, -1, 2 };
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("Max subarray sum: " + sol.maxSubArray(nums5)); // 4 ([2,-1,2,-1,2] or [2,-1,2])
    }
}
