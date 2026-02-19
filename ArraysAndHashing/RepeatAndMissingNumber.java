package ArraysAndHashing;

import java.util.Arrays;

public class RepeatAndMissingNumber {

    public int[] findMissingRepeatingNumbers(int[] nums) {
        int N = nums.length;

        int SN = (N * (N + 1)) / 2;
        int SN2 = (N * (N + 1) * (2 * N + 1)) / 6;

        int sumArr = 0;
        int sumArr2 = 0;
        for (int i = 0; i < N; i++) {
            sumArr += nums[i];
            sumArr2 += nums[i] * nums[i];
        }

        int val1 = sumArr - SN;
        int val2 = (sumArr2 - SN2) / val1;
        int x = (val1 + val2) / 2;
        int y = x - val1;
        return new int[] { x, y };
    }

    public static void main(String[] args) {
        RepeatAndMissingNumber sol = new RepeatAndMissingNumber();

        // Test case 1: Basic - repeat 2, missing 5
        int[] arr1 = { 4, 2, 2, 1, 5, 0 };
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("Result: " + Arrays.toString(sol.findMissingRepeatingNumbers(arr1)));
        System.out.println("Expected: [2, 5]\n"); // Missing 5, Repeat 2[cite:16]

        // Test case 2: Repeat at end
        int[] arr2 = { 1, 3, 4, 2, 2 };
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("Result: " + Arrays.toString(sol.findMissingRepeatingNumbers(arr2)));
        System.out.println("Expected: [2, 5]\n");

        // Test case 3: Repeat at start
        int[] arr3 = { 3, 1, 2, 1, 4 };
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("Result: " + Arrays.toString(sol.findMissingRepeatingNumbers(arr3)));
        System.out.println("Expected: [1, 5]\n");

        // Test case 4: Larger N
        int[] arr4 = { 6, 4, 3, 5, 3, 2, 1 };
        System.out.println("arr4: " + Arrays.toString(arr4));
        System.out.println("Result: " + Arrays.toString(sol.findMissingRepeatingNumbers(arr4)));
        System.out.println("Expected: [3, 7]\n");

        // Test case 5: N=2 edge
        int[] arr5 = { 1, 1 };
        System.out.println("arr5: " + Arrays.toString(arr5));
        System.out.println("Result: " + Arrays.toString(sol.findMissingRepeatingNumbers(arr5)));
        System.out.println("Expected: [1, 2]");
    }
}
