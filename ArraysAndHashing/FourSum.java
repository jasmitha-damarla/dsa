package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> sol = new ArrayList<>();
        int N = nums.length;
        if (N < 4)
            return sol;
        Arrays.sort(nums);

        for (int i = 0; i < N - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < N - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1, l = N - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        sol.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1])
                            k++;
                        while (k < l && nums[l] == nums[l + 1])
                            l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        FourSum sol = new FourSum();

        // Test case 1: LeetCode standard [web:66]
        int[] nums1 = { 1, 0, -1, 0, -2, 2 };
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("4Sum(target=0): " + sol.fourSum(nums1, 0));
        System.out.println();

        // Test case 2: Overflow protection test [web:63]
        int[] nums2 = { 1000000000, 1000000000, 1000000000, 1000000000 };
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("4Sum(target=-294967296): " + sol.fourSum(nums2, -294967296));
        System.out.println();

        // Test case 3: All identical elements
        int[] nums3 = { 2, 2, 2, 2, 2 };
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("4Sum(target=8): " + sol.fourSum(nums3, 8));
        System.out.println();

        // Test case 4: Multiple quadruplets target=0
        int[] nums4 = { -3, -2, -1, 0, 0, 1, 2, 3 };
        System.out.println("nums4: " + Arrays.toString(nums4));
        System.out.println("4Sum(target=0): " + sol.fourSum(nums4, 0));
        System.out.println();

        // Test case 5: Negative target
        int[] nums5 = { -5, -3, -1, 0, 1, 2 };
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("4Sum(target=-9): " + sol.fourSum(nums5, -9));
        System.out.println();

        // Test case 6: Large numbers + overflow risk
        int[] nums6 = { 1000, 1000, 1000, -3000 };
        System.out.println("nums6: " + Arrays.toString(nums6));
        System.out.println("4Sum(target=0): " + sol.fourSum(nums6, 0));
        System.out.println();

        // Test case 7: Edge cases
        int[] nums7 = { 1, 2, 3 };
        System.out.println("nums7: " + Arrays.toString(nums7));
        System.out.println("4Sum(target=6): " + sol.fourSum(nums7, 6)); // N<4 → []

        int[] nums8 = {};
        System.out.println("nums8: " + Arrays.toString(nums8));
        System.out.println("4Sum(target=0): " + sol.fourSum(nums8, 0)); // []
    }
}
