package ArraysAndHashing;

import java.util.Arrays;

public class MajorityElement {

    public int majorityElement(int[] nums) {
        int c = 0, curEle = -1, N = nums.length;
        for (int i = 0; i < N; i++) {
            if (c == 0) {
                c = 1;
                curEle = nums[i];
            } else if (nums[i] == curEle) {
                c++;
            } else {
                c--;
            }
        }

        int v = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] == curEle) {
                v++;
            }
        }
        if (v > (N / 2)) {
            return curEle;
        }
        return -1;
    }

    public static void main(String[] args) {
        MajorityElement sol = new MajorityElement();

        // Test case 1: Standard majority
        int[] nums1 = { 1, 2, 2, 1, 2 };
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("Majority (>n/2): " + sol.majorityElement(nums1)); // 2
        System.out.println();

        // Test case 2: Majority at end
        int[] nums2 = { 3, 3, 3, 1, 2 };
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Majority (>n/2): " + sol.majorityElement(nums2)); // 3
        System.out.println();

        // Test case 3: No majority
        int[] nums3 = { 1, 2, 3, 4 };
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("Majority (>n/2): " + sol.majorityElement(nums3)); // -1
        System.out.println();

        // Test case 4: All same (majority)
        int[] nums4 = { 5, 5, 5, 5 };
        System.out.println("nums4: " + Arrays.toString(nums4));
        System.out.println("Majority (>n/2): " + sol.majorityElement(nums4)); // 5
        System.out.println();

        // Test case 5: Edge case n=1
        int[] nums5 = { 7 };
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("Majority (>n/2): " + sol.majorityElement(nums5)); // 7
    }
}
