package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

    // ✅ Optimal Sliding Window (works for +ve, -ve, zeros)
    public int longestSubarray(int[] nums, int k) {
        int l = 0, r = 0, sum = nums[0], N = nums.length;
        int maxLen = 0;
        while (r < N) {
            while (l <= r && sum > k) {
                sum -= nums[l];
                l++;
            }
            if (sum == k) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
            if (r < N) {
                sum += nums[r];
            }
        }
        return maxLen;
    }

    // Better Approach HashMap prefixSum
    public int maxLen(int[] nums, int k) {
        int maxLen = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            }
            int r = sum - k;
            if (map.containsKey(r)) {
                maxLen = Math.max(maxLen, i - map.get(r));
            }
            map.put(sum, i); // Better Approach only for +ves

            // Optimal Approach for +ves, -ves and zeros
            // if(!map.containsKey(sum)) {
            // map.put(sum, i);
            // }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubarrayWithSumK sol = new LongestSubarrayWithSumK();

        // Test case 1: Standard positive numbers
        int[] nums1 = { 1, 2, 3, 1, 1 };
        int k1 = 3;
        System.out.println("nums: " + Arrays.toString(nums1) + ", k=" + k1);
        System.out.println("Longest subarray sum=k: " + sol.longestSubarray(nums1, k1)); // 3 ([1,2])
        System.out.println();

        // Test case 2: Zeros and negatives (sum=0)
        int[] nums2 = { 1, -1, 1, -1, 1 };
        int k2 = 0;
        System.out.println("nums: " + Arrays.toString(nums2) + ", k=" + k2);
        System.out.println("Longest subarray sum=k: " + sol.longestSubarray(nums2, k2)); // 5
        System.out.println();

        // Test case 3: No subarray equals k
        int[] nums3 = { 1, 2, 4 };
        int k3 = 5;
        System.out.println("nums: " + Arrays.toString(nums3) + ", k=" + k3);
        System.out.println("Longest subarray sum=k: " + sol.longestSubarray(nums3, k3)); // 0
        System.out.println();

        // Test case 4: Single element match
        int[] nums4 = { 3 };
        int k4 = 3;
        System.out.println("nums: " + Arrays.toString(nums4) + ", k=" + k4);
        System.out.println("Longest subarray sum=k: " + sol.longestSubarray(nums4, k4)); // 1
        System.out.println();

        // Test case 5: Multiple matches, pick longest
        int[] nums5 = { 1, 2, 1, 3, 1 };
        int k5 = 3;
        System.out.println("nums: " + Arrays.toString(nums5) + ", k=" + k5);
        System.out.println("Longest subarray sum=k: " + sol.longestSubarray(nums5, k5)); // 3 ([1,2]) or [3]
    }
}
