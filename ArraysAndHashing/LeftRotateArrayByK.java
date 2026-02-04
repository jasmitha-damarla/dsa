package ArraysAndHashing;

import java.util.Arrays;

public class LeftRotateArrayByK {

    public void rotateArray(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = nums[i];
        }
        for (int i = k; i < N; i++) {
            nums[i - k] = nums[i];
        }
        for (int i = N - k; i < N; i++) {
            nums[i] = temp[i - (N - k)];
        }
    }

    private void swap(int[] arr, int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    private void reverseAnArray(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l, r);
            reverseAnArray(arr, l + 1, r - 1);
        }
    }

    private void optimalRotate(int[] nums, int k) {
        int N = nums.length;
        k = k % N;
        reverseAnArray(nums, 0, k - 1);
        reverseAnArray(nums, k, N - 1);
        reverseAnArray(nums, 0, N - 1);

    }

    public static void main(String[] args) {
        LeftRotateArrayByK sol = new LeftRotateArrayByK();

        // Test case 1: k=2, left rotate
        int[] nums1 = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("Before: " + Arrays.toString(nums1));
        sol.rotateArray(nums1, 2);
        System.out.println("After k=2:  " + Arrays.toString(nums1)); // [3,4,5,6,7,1,2]
        System.out.println();

        // Test case 2: k=3
        int[] nums2 = { 1, 2, 3, 4, 5 };
        System.out.println("Before: " + Arrays.toString(nums2));
        sol.rotateArray(nums2, 3);
        System.out.println("After k=3:  " + Arrays.toString(nums2)); // [4,5,1,2,3]
        System.out.println();

        // Test case 3: k larger than N (modulo handles)
        int[] nums3 = { 1, 2, 3 };
        System.out.println("Before: " + Arrays.toString(nums3));
        sol.rotateArray(nums3, 7); // 7%3 = 1
        System.out.println("After k=7:  " + Arrays.toString(nums3)); // [2,3,1]
        System.out.println();

        // Test case 4: k=0 or multiple of N
        int[] nums4 = { 1, 2, 3, 4 };
        System.out.println("Before: " + Arrays.toString(nums4));
        sol.rotateArray(nums4, 4); // 4%4 = 0
        System.out.println("After k=4:  " + Arrays.toString(nums4)); // [1,2,3,4]

        // Optimal Approach to reduce space
        sol.optimalRotate(nums4, 4);
        System.out.println("Optimal approach " + Arrays.toString(nums4));
    }

}
