package ArraysAndHashing;

import java.util.Arrays;

public class MoveZerosToEnd {

    public void moveZeroes(int[] nums) {
        int j = -1, N = nums.length;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1) {
            return;
        }
        for (int i = j + 1; i < N; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
    }

    private void swap(int[] arr, int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    public static void main(String[] args) {
        MoveZerosToEnd sol = new MoveZerosToEnd();

        // Test case 1: Standard mixed
        int[] nums1 = { 1, 0, 3, 0, 5, 0, 7 };
        System.out.println("Before: " + Arrays.toString(nums1));
        sol.moveZeroes(nums1);
        System.out.println("After:  " + Arrays.toString(nums1)); // [1,3,5,7,0,0,0]
        System.out.println();

        // Test case 2: Zeros at beginning
        int[] nums2 = { 0, 0, 1, 2, 3 };
        System.out.println("Before: " + Arrays.toString(nums2));
        sol.moveZeroes(nums2);
        System.out.println("After:  " + Arrays.toString(nums2)); // [1,2,3,0,0]
        System.out.println();

        // Test case 3: No zeros
        int[] nums3 = { 1, 2, 3, 4 };
        System.out.println("Before: " + Arrays.toString(nums3));
        sol.moveZeroes(nums3);
        System.out.println("After:  " + Arrays.toString(nums3)); // [1,2,3,4]
        System.out.println();

        // Test case 4: All zeros
        int[] nums4 = { 0, 0, 0, 0 };
        System.out.println("Before: " + Arrays.toString(nums4));
        sol.moveZeroes(nums4);
        System.out.println("After:  " + Arrays.toString(nums4)); // [0,0,0,0]
        System.out.println();

        // Test case 5: Single zero
        int[] nums5 = { 1, 0 };
        System.out.println("Before: " + Arrays.toString(nums5));
        sol.moveZeroes(nums5);
        System.out.println("After:  " + Arrays.toString(nums5)); // [1,0]
    }
}
