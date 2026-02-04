package ArraysAndHashing;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] a, int N) {
        int xor1 = 0, xor2 = 0;
        for (int i = 0; i < N; i++) {
            xor2 = xor2 ^ a[i];
            xor1 = xor1 ^ (i + 1);
        }
        xor1 = xor1 ^ N;
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        IntersectionOfTwoSortedArrays sol = new IntersectionOfTwoSortedArrays();

        // Test case 1: Common elements with duplicates
        int[] nums1 = { 1, 2, 2, 2, 4 };
        int[] nums2 = { 2, 2, 4, 4, 5 };
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        int[] result1 = sol.intersection(nums1, nums2);
        System.out.println("Intersection: " + Arrays.toString(result1)); // [2, 2, 4]
        System.out.println();

        // Test case 2: No common elements
        int[] nums3 = { 1, 3, 5 };
        int[] nums4 = { 2, 4, 6 };
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("nums4: " + Arrays.toString(nums4));
        int[] result2 = sol.intersection(nums3, nums4);
        System.out.println("Intersection: " + Arrays.toString(result2)); // []
        System.out.println();

        // Test case 3: One common element
        int[] nums5 = { 1, 2, 3 };
        int[] nums6 = { 3, 4, 5 };
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("nums6: " + Arrays.toString(nums6));
        int[] result3 = sol.intersection(nums5, nums6);
        System.out.println("Intersection: " + Arrays.toString(result3)); // [3]
        System.out.println();

        // Test case 4: One empty array
        int[] nums7 = { 1, 2, 3 };
        int[] nums8 = {};
        System.out.println("nums7: " + Arrays.toString(nums7));
        System.out.println("nums8: " + Arrays.toString(nums8));
        int[] result4 = sol.intersection(nums7, nums8);
        System.out.println("Intersection: " + Arrays.toString(result4)); // []
    }

}
