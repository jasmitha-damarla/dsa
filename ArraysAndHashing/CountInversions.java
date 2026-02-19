package ArraysAndHashing;

import java.util.Arrays;

public class CountInversions {

    public int merge(int[] arr, int low, int mid, int high) {
        // Temporary array
        int[] temp = new int[high - low + 1];

        // Starting indices of left and right halves
        int left = low;
        int right = mid + 1;
        int k = 0;

        // Variable to count inversions
        int cnt = 0;

        // Merge elements in sorted order
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
                cnt += (mid - left + 1); // Count inversions
            }
        }

        // Copy remaining elements of left half
        while (left <= mid) {
            temp[k++] = arr[left++];
        }

        // Copy remaining elements of right half
        while (right <= high) {
            temp[k++] = arr[right++];
        }

        // Copy back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return cnt;
    }

    // Merge sort function
    public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;

        if (low >= high)
            return cnt;

        int mid = (low + high) / 2;

        // Count inversions in left half
        cnt += mergeSort(arr, low, mid);
        // Count inversions in right half
        cnt += mergeSort(arr, mid + 1, high);
        // Count inversions during merge
        cnt += merge(arr, low, mid, high);

        return cnt;
    }

    // Function to get number of inversions
    public int numberOfInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        CountInversions sol = new CountInversions();

        // Test case 1: Basic inversions
        int[] arr1 = { 1, 20, 6, 4, 5 };
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("Inversions: " + sol.numberOfInversions(arr1));
        System.out.println("Expected: 5 (20>6,20>4,20>5,6>4,6>5)\n"); // [1,4,5,6,20]

        // Test case 2: Sorted (0 inversions)
        int[] arr2 = { 1, 2, 3, 4, 5 };
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("Inversions: " + sol.numberOfInversions(arr2));
        System.out.println("Expected: 0\n");

        // Test case 3: Reverse sorted (max inversions)
        int[] arr3 = { 5, 4, 3, 2, 1 };
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("Inversions: " + sol.numberOfInversions(arr3));
        System.out.println("Expected: 10\n");

        // Test case 4: Duplicates
        int[] arr4 = { 10, 10, 20, 30 };
        System.out.println("arr4: " + Arrays.toString(arr4));
        System.out.println("Inversions: " + sol.numberOfInversions(arr4));
        System.out.println("Expected: 0 (stable: equal not inversion)\n");

        // Test case 5: Single element
        int[] arr5 = { 42 };
        System.out.println("arr5: " + Arrays.toString(arr5));
        System.out.println("Inversions: " + sol.numberOfInversions(arr5));
        System.out.println("Expected: 0");
    }
}
