package ArraysAndHashing;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = (len / 2) + (len % 2);
        while (gap > 0) {
            int l = 0;
            int r = gap;
            while (r < len) { // l < len with else at line 22
                // nums1 and nums2
                if (l < m && r >= m) {
                    swapIfGreater(nums1, nums2, l, r - m);
                }
                // nums2 and nums2
                else if (l >= m) {
                    swapIfGreater(nums2, nums2, l - m, r - m);
                }
                // nums1 and nums1
                else {
                    swapIfGreater(nums1, nums1, l, r);
                }
                l++;
                r++;
            }
            if (gap == 1) {
                break;
            }
            gap = (gap / 2) + (gap % 2);
        }
    }

    private void swapIfGreater(int[] arr1, int[] arr2, int x, int y) {
        if (arr1[x] > arr2[y]) {
            int t = arr1[x];
            arr1[x] = arr2[y];
            arr2[y] = t;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedArrays sol = new MergeTwoSortedArrays();

        // Test case 1: LeetCode example
        int[] nums1_1 = { 1, 2, 3, 0, 0, 0 };
        int m1 = 3;
        int[] nums2_1 = { 2, 5, 6 };
        int n1 = 3;
        System.out.println("Before: nums1=" + Arrays.toString(nums1_1) + ", nums2=" + Arrays.toString(nums2_1));
        sol.merge(nums1_1, m1, nums2_1, n1);
        System.out.println("After:  nums1=" + Arrays.toString(nums1_1));
        System.out.println("Expected: [1,2,2,3,5,6]");

        // Test case 2: nums1 empty
        int[] nums1_2 = { 0 };
        int m2 = 0;
        int[] nums2_2 = { 1 };
        int n2 = 1;
        System.out.println("\nBefore: nums1=" + Arrays.toString(nums1_2) + ", nums2=" + Arrays.toString(nums2_2));
        sol.merge(nums1_2, m2, nums2_2, n2);
        System.out.println("After:  nums1=" + Arrays.toString(nums1_2));
        System.out.println("Expected: [1]");

        // Test case 3: nums2 empty
        int[] nums1_3 = { 1 };
        int m3 = 1;
        int[] nums2_3 = {};
        int n3 = 0;
        System.out.println("\nBefore: nums1=" + Arrays.toString(nums1_3) + ", nums2=" + Arrays.toString(nums2_3));
        sol.merge(nums1_3, m3, nums2_3, n3);
        System.out.println("After:  nums1=" + Arrays.toString(nums1_3));
        System.out.println("Expected: [1]");

        // Test case 4: All elements equal
        int[] nums1_4 = { 1, 0 };
        int m4 = 1;
        int[] nums2_4 = { 1 };
        int n4 = 1;
        System.out.println("\nBefore: nums1=" + Arrays.toString(nums1_4) + ", nums2=" + Arrays.toString(nums2_4));
        sol.merge(nums1_4, m4, nums2_4, n4);
        System.out.println("After:  nums1=" + Arrays.toString(nums1_4));
        System.out.println("Expected: [1,1]");
    }
}
