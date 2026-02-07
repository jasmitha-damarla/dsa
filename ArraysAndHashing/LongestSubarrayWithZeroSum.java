package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithZeroSum {
    public int maxLen(int[] A, int n) {
        // map prefix sum -> first index seen
        Map<Integer, Integer> mpp = new HashMap<>();
        int maxi = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];

            if (sum == 0) {
                maxi = i + 1;
            } else {
                if (mpp.containsKey(sum)) {
                    maxi = Math.max(maxi, i - mpp.get(sum));
                } else {
                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        LongestSubarrayWithZeroSum sol = new LongestSubarrayWithZeroSum();

        // Test case 1: Standard zero sum
        int[] arr1 = { 15, -2, 4, -8, 1, 7, 8, 10 };
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("Longest zero sum subarray: " + sol.maxLen(arr1, arr1.length)); // 4 ([-2,4,-8,1] or
                                                                                           // [4,-8,1,7])
        System.out.println();

        // Test case 2: Whole array sums to zero
        int[] arr2 = { 1, -1, 1, -1 };
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("Longest zero sum subarray: " + sol.maxLen(arr2, arr2.length)); // 4
        System.out.println();

        // Test case 3: No zero sum
        int[] arr3 = { 1, 2, 3, 4 };
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("Longest zero sum subarray: " + sol.maxLen(arr3, arr3.length)); // 0
        System.out.println();

        // Test case 4: Single zero
        int[] arr4 = { 0 };
        System.out.println("arr4: " + Arrays.toString(arr4));
        System.out.println("Longest zero sum subarray: " + sol.maxLen(arr4, arr4.length)); // 1
        System.out.println();

        // Test case 5: Multiple zero sums
        int[] arr5 = { 4, 2, -3, 1, 6 };
        System.out.println("arr5: " + Arrays.toString(arr5));
        System.out.println("Longest zero sum subarray: " + sol.maxLen(arr5, arr5.length)); // 2 ([4,-3,1] prefix=2, but
                                                                                           // longest is 2)
    }
}
