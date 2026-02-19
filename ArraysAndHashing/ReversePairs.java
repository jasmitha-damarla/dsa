package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePairs {

    private void merge(int[] arr, int low, int mid, int high) {
        List<Integer> temp = new ArrayList<>(); // temporary array
        int left = low; // starting index of left half of arr
        int right = mid + 1; // starting index of right half of arr

        // storing elements in the temporary array in a sorted manner//
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    private int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2L * (long) arr[right])
                right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    private int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high)
            return cnt;
        int mid = (low + high) / 2;
        cnt += mergeSort(arr, low, mid); // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += countPairs(arr, low, mid, high); // Modification
        merge(arr, low, mid, high); // merging sorted halves
        return cnt;
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        ReversePairs sol = new ReversePairs();

        // Test case 1: LeetCode sample
        int[] nums1 = { 1, 3, 2, 3, 1 };
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("Reverse pairs: " + sol.reversePairs(nums1));
        System.out.println("Expected: 2 (3>2*1, 3>2*1)\n");

        // Test case 2: All INT_MAX (overflow test)
        int[] nums2 = { 2147483647, 2147483647, 2147483647 };
        System.out.println("nums2: " + Arrays.toString(nums2));
        System.out.println("Reverse pairs: " + sol.reversePairs(nums2));
        System.out.println("Expected: 0\n");

        // Test case 3: Reverse sorted
        int[] nums3 = { 5, 4, 3, 2, 1 };
        System.out.println("nums3: " + Arrays.toString(nums3));
        System.out.println("Reverse pairs: " + sol.reversePairs(nums3));
        System.out.println("Expected: 10\n");

        // Test case 4: Sorted
        int[] nums4 = { 1, 2, 3, 4, 5 };
        System.out.println("nums4: " + Arrays.toString(nums4));
        System.out.println("Reverse pairs: " + sol.reversePairs(nums4));
        System.out.println("Expected: 0\n");

        // Test case 5: Negatives and overflow safe
        int[] nums5 = { 2, 4, 3, -1, 5 };
        System.out.println("nums5: " + Arrays.toString(nums5));
        System.out.println("Reverse pairs: " + sol.reversePairs(nums5));
        System.out.println("Expected: 3");
    }
}
