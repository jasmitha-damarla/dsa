package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfTwoSortedArrays {

    public int[] unionArray(int[] nums1, int[] nums2) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;
        int N1 = nums1.length, N2 = nums2.length;
        while (i < N1 && j < N2) {
            if (nums1[i] < nums2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
            } else if (nums1[i] > nums2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != nums2[j]) {
                    union.add(nums2[j]);
                }
                j++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != nums1[i]) {
                    union.add(nums1[i]);
                }
                i++;
                j++;
            }
        }
        while (i < N1) {
            if (union.isEmpty() || union.get(union.size() - 1) != nums1[i]) {
                union.add(nums1[i]);
            }
            i++;
        }
        while (j < N2) {
            if (union.isEmpty() || union.get(union.size() - 1) != nums2[j]) {
                union.add(nums2[j]);
            }
            j++;
        }
        return union.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        UnionOfTwoSortedArrays sol = new UnionOfTwoSortedArrays();

        // Test case 1: Standard with duplicates
        int[] nums1 = { 1, 2, 2, 2, 4 };
        int[] nums2 = { 2, 2, 4, 4 };
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));
        int[] result1 = sol.unionArray(nums1, nums2);
        System.out.println("Union: " + Arrays.toString(result1)); // [1,2,4]
        System.out.println();

        // Test case 2: No common elements
        int[] nums3 = { 1, 3, 5 };
        int[] nums4 = { 2, 4, 6 };
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("nums4: " + Arrays.toString(nums4));
        int[] result2 = sol.unionArray(nums3, nums4);
        System.out.println("Union: " + Arrays.toString(result2)); // [1,2,3,4,5,6]
        System.out.println();

        // Test case 3: One empty array
        int[] nums5 = { 1, 2, 3 };
        int[] nums6 = {};
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("nums6: " + Arrays.toString(nums6));
        int[] result3 = sol.unionArray(nums5, nums6);
        System.out.println("Union: " + Arrays.toString(result3)); // [1,2,3]
        System.out.println();

        // Test case 4: All identical elements
        int[] nums7 = { 5, 5, 5 };
        int[] nums8 = { 5, 5 };
        System.out.println("nums7: " + Arrays.toString(nums7));
        System.out.println("nums8: " + Arrays.toString(nums8));
        int[] result4 = sol.unionArray(nums7, nums8);
        System.out.println("Union: " + Arrays.toString(result4)); // [5]
    }

}
