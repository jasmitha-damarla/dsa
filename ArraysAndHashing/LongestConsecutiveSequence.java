package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int N = nums.length;
        if (N == 0)
            return 0; // important edge case

        int maxSeq = 1;
        Set<Integer> sol = new HashSet<>();
        for (int i = 0; i < N; i++) {
            sol.add(nums[i]);
        }

        for (int cur : sol) {
            // Only start counting if cur is the START of a sequence
            if (!sol.contains(cur - 1)) {
                int c = 1;
                int x = cur;
                while (sol.contains(x + 1)) {
                    x++;
                    c++;
                }
                maxSeq = Math.max(maxSeq, c);
            }
        }
        return maxSeq;
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence sol = new LongestConsecutiveSequence();

        // Test case 1: Standard example
        int[] nums1 = { 100, 4, 200, 1, 3, 2 };
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("Longest consecutive length: " + sol.longestConsecutive(nums1)); // 4 ([1,2,3,4])
        System.out.println();

        // Test case 2: With duplicates
        int[] nums2 = { 1, 2, 2, 3 };
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Longest consecutive length: " + sol.longestConsecutive(nums2)); // 3 ([1,2,3])
        System.out.println();

        // Test case 3: Single element
        int[] nums3 = { 7 };
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("Longest consecutive length: " + sol.longestConsecutive(nums3)); // 1
        System.out.println();

        // Test case 4: Empty array
        int[] nums4 = {};
        System.out.println("nums4: " + Arrays.toString(nums4));
        System.out.println("Longest consecutive length: " + sol.longestConsecutive(nums4)); // 0
        System.out.println();

        // Test case 5: Mixed scattered
        int[] nums5 = { 9, 1, 4, 7, 3, 2, 6, 8 };
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("Longest consecutive length: " + sol.longestConsecutive(nums5)); // 6 ([3,4,5,6,7,8] if 5
                                                                                            // present, here 5 missing
                                                                                            // so 4: [6,7,8,9])
    }
}
