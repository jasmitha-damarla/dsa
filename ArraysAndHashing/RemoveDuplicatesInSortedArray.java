package ArraysAndHashing;

import java.util.Arrays;

public class RemoveDuplicatesInSortedArray {

    public int removeDuplicates(int[] nums) {
        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[l]) {
                nums[l + 1] = nums[r];
                l++;
            }
        }
        return l + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesInSortedArray sol = new RemoveDuplicatesInSortedArray();

        // Test case 1: Standard duplicates
        int[] nums1 = { 1, 1, 2 };
        System.out.println("Before: " + Arrays.toString(nums1));
        int k1 = sol.removeDuplicates(nums1);
        System.out.println("After:  " + Arrays.toString(nums1));
        System.out.println("k = " + k1 + ", first " + k1 + " unique: " +
                Arrays.toString(Arrays.copyOf(nums1, k1))); // [1,2]
        System.out.println();

        // Test case 2: Multiple duplicates
        int[] nums2 = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println("Before: " + Arrays.toString(nums2));
        int k2 = sol.removeDuplicates(nums2);
        System.out.println("After:  " + Arrays.toString(nums2));
        System.out.println("k = " + k2 + ", first " + k2 + " unique: " +
                Arrays.toString(Arrays.copyOf(nums2, k2))); // [0,1,2,3,4]
        System.out.println();

        // Test case 3: All duplicates
        int[] nums3 = { 1, 1, 1 };
        System.out.println("Before: " + Arrays.toString(nums3));
        int k3 = sol.removeDuplicates(nums3);
        System.out.println("After:  " + Arrays.toString(nums3));
        System.out.println("k = " + k3); // 1
        System.out.println();

        // Test case 4: No duplicates
        int[] nums4 = { 1, 2, 3 };
        System.out.println("Before: " + Arrays.toString(nums4));
        int k4 = sol.removeDuplicates(nums4);
        System.out.println("After:  " + Arrays.toString(nums4));
        System.out.println("k = " + k4); // 3
    }

}
