package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoSortedArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> intersection = new ArrayList<>();
        int i = 0, j = 0;
        int N1 = nums1.length, N2 = nums2.length;

        while (i < N1 && j < N2) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                intersection.add(nums1[i]);
                i++;
                j++;
            }
        }
        return intersection.stream().mapToInt(Integer::valueOf).toArray();
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
