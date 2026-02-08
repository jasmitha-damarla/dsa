package ArraysAndHashing;

import java.util.Arrays;

public class NextPermutation {

    private void swap(int[] arr, int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    private void reverseAnArray(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    public void nextPermutation(int[] nums) {
        int x = -1, N = nums.length;
        for (int i = N - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                x = i;
                break;
            }
        }
        if (x == -1) {
            reverseAnArray(nums, 0, N - 1);
        } else {
            for (int i = N - 1; i > x; i--) {
                if (nums[i] > nums[x]) {
                    swap(nums, x, i);
                    break;
                }
            }
            reverseAnArray(nums, x + 1, N - 1);
        }
    }

    public static void main(String[] args) {
        NextPermutation sol = new NextPermutation();

        int[] a1 = { 1, 2, 3 };
        System.out.println("Before: " + Arrays.toString(a1));
        sol.nextPermutation(a1);
        System.out.println("After : " + Arrays.toString(a1)); // [1, 3, 2]
        System.out.println();

        int[] a2 = { 1, 3, 2 };
        System.out.println("Before: " + Arrays.toString(a2));
        sol.nextPermutation(a2);
        System.out.println("After : " + Arrays.toString(a2)); // [2, 1, 3]
        System.out.println();

        int[] a3 = { 3, 2, 1 };
        System.out.println("Before: " + Arrays.toString(a3));
        sol.nextPermutation(a3);
        System.out.println("After : " + Arrays.toString(a3)); // [1, 2, 3]
        System.out.println();

        int[] a4 = { 1, 1, 5 };
        System.out.println("Before: " + Arrays.toString(a4));
        sol.nextPermutation(a4);
        System.out.println("After : " + Arrays.toString(a4)); // [1, 5, 1]
        System.out.println();

        int[] a5 = { 2, 3, 1 };
        System.out.println("Before: " + Arrays.toString(a5));
        sol.nextPermutation(a5);
        System.out.println("After : " + Arrays.toString(a5)); // [3, 1, 2]
    }
}
