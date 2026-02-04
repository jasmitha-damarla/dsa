package ArraysAndHashing;

import java.util.Arrays;

public class MaximumConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cur = 0;
            } else {
                cur++;
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumConsecutiveOnes sol = new MaximumConsecutiveOnes();

        // Test case 1: Standard mixed
        int[] nums1 = { 1, 1, 0, 1, 1, 1 };
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("Max consecutive ones: " + sol.findMaxConsecutiveOnes(nums1)); // 3
        System.out.println();

        // Test case 2: All ones
        int[] nums2 = { 1, 1, 1, 1, 1 };
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Max consecutive ones: " + sol.findMaxConsecutiveOnes(nums2)); // 5
        System.out.println();

        // Test case 3: All zeros
        int[] nums3 = { 0, 0, 0 };
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("Max consecutive ones: " + sol.findMaxConsecutiveOnes(nums3)); // 0
        System.out.println();

        // Test case 4: Single elements
        int[] nums4 = { 0, 1, 0, 1 };
        System.out.println("nums4: " + Arrays.toString(nums4));
        System.out.println("Max consecutive ones: " + sol.findMaxConsecutiveOnes(nums4)); // 1
        System.out.println();

        // Test case 5: Ends with ones
        int[] nums5 = { 1, 0, 1, 1, 1, 0, 1 };
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("Max consecutive ones: " + sol.findMaxConsecutiveOnes(nums5)); // 3
    }

}
