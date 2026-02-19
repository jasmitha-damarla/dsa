package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MajorityElementII {

    public List<Integer> majorityElementTwo(int[] nums) {
        int c1 = 0, c2 = 0, N = nums.length;
        List<Integer> sol = new ArrayList<>();
        int ele1 = Integer.MIN_VALUE, ele2 = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (c1 == 0 && nums[i] != ele2) {
                c1 = 1;
                ele1 = nums[i];
            } else if (c2 == 0 && nums[i] != ele1) {
                c2 = 1;
                ele2 = nums[i];
            } else if (ele1 == nums[i]) {
                c1++;
            } else if (ele2 == nums[i]) {
                c2++;
            } else {
                c1--;
                c2--;
            }
        }
        int v1 = 0, v2 = 0;
        int minVal = (N / 3) + 1;
        for (int i = 0; i < N; i++) {
            if (ele1 == nums[i]) {
                v1++;
            }
            if (ele2 == nums[i]) {
                v2++;
            }
        }
        if (v1 >= minVal) {
            sol.add(ele1);
        }
        if (v2 >= minVal) {
            sol.add(ele2);
        }
        sol.sort(Comparator.naturalOrder());
        return sol;
    }

    public static void main(String[] args) {
        MajorityElementII sol = new MajorityElementII();

        // Test case 1: Two majority > n/3 [web:37]
        int[] nums1 = { 5, 2, 3, 2, 2, 2, 2, 5, 5, 5 };
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("Majority: " + sol.majorityElementTwo(nums1)); // [2,5]
        System.out.println();

        // Test case 2: Single majority [web:37]
        int[] nums2 = { 4, 4, 4, 4, 4 };
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Majority: " + sol.majorityElementTwo(nums2)); // [4]
        System.out.println();

        // Test case 3: No majority [web:37]
        int[] nums3 = { 1, 2, 3 };
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("Majority: " + sol.majorityElementTwo(nums3)); // []
        System.out.println();

        // Test case 4: Exactly n/3+1 [web:34]
        int[] nums4 = { 2, 2, 3, 1, 3, 2, 1, 1 };
        System.out.println("nums4: " + Arrays.toString(nums4));
        System.out.println("Majority: " + sol.majorityElementTwo(nums4)); // [1,2]
        System.out.println();

        // Test case 5: Negatives & duplicates [web:34]
        int[] nums5 = { -5, 3, -5 };
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("Majority: " + sol.majorityElementTwo(nums5)); // [-5]
        System.out.println();

        // Test case 6: All unique
        int[] nums6 = { 1, 2, 3, 4, 5, 6 };
        System.out.println("nums6: " + Arrays.toString(nums6));
        System.out.println("Majority: " + sol.majorityElementTwo(nums6)); // []
    }
}
