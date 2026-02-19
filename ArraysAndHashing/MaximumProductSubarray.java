package ArraysAndHashing;

import java.util.Arrays;

public class MaximumProductSubarray {

    public int maxProductSubArray(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;
        int N = arr.length;

        for (int i = 0; i < N; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }
            prefix *= arr[i];
            suffix *= arr[N - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(prefix, suffix));
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductSubarray sol = new MaximumProductSubarray();

        // Test case 1: GFG example - negatives create max
        int[] arr1 = { -1, -3, -10, 0, 60 };
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("Max product: " + sol.maxProductSubArray(arr1));
        System.out.println("Expected: 30 (-3*-10)\n"); // Prefix/suffix catches it!

        // Test case 2: All positive
        int[] arr2 = { 2, 3, -2, 4 };
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("Max product: " + sol.maxProductSubArray(arr2));
        System.out.println("Expected: 6 (2*3)\n");

        // Test case 3: Single negative
        int[] arr3 = { -2 };
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("Max product: " + sol.maxProductSubArray(arr3));
        System.out.println("Expected: -2\n");

        // Test case 4: Zeros reset
        int[] arr4 = { -2, 0, -1 };
        System.out.println("arr4: " + Arrays.toString(arr4));
        System.out.println("Max product: " + sol.maxProductSubArray(arr4));
        System.out.println("Expected: 0\n");

        // Test case 5: All zeros
        int[] arr5 = { 0, 0 };
        System.out.println("arr5: " + Arrays.toString(arr5));
        System.out.println("Max product: " + sol.maxProductSubArray(arr5));
        System.out.println("Expected: 0");
    }
}
