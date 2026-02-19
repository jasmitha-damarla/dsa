package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] arr, int n) {
        Arrays.sort(arr);
        List<List<Integer>> sol = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    sol.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) {
        ThreeSum sol = new ThreeSum();

        // Test case 1: LeetCode classic [web:54]
        int[] arr1 = { -1, 0, 1, 2, -1, -4 };
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("3Sum: " + sol.threeSum(arr1, arr1.length)); // [[-1,-1,2],[-1,0,1]]
        System.out.println();

        // Test case 2: No solution [web:54]
        int[] arr2 = { 0, 1, 1 };
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("3Sum: " + sol.threeSum(arr2, arr2.length)); // []
        System.out.println();

        // Test case 3: All zeros [web:49]
        int[] arr3 = { 0, 0, 0 };
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("3Sum: " + sol.threeSum(arr3, arr3.length)); // [[0,0,0]]
        System.out.println();

        // Test case 4: Multiple triplets [web:50]
        int[] arr4 = { -2, 0, 1, 1, 2 };
        System.out.println("arr4: " + Arrays.toString(arr4));
        System.out.println("3Sum: " + sol.threeSum(arr4, arr4.length)); // [[-2,0,2],[-2,1,1],[0,1,1]]
        System.out.println();

        // Test case 5: Duplicates heavy [web:56]
        int[] arr5 = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
        System.out.println("arr5: " + Arrays.toString(arr5));
        System.out.println("3Sum: " + sol.threeSum(arr5, arr5.length));
        // [[-4,-2,6],[-4,0,4],[-4,1,3],[-4,2,2],[-2,-2,4],[-2,0,2]]
        System.out.println();

        // Test case 6: Single element (edge)
        int[] arr6 = { 0 };
        System.out.println("arr6: " + Arrays.toString(arr6));
        System.out.println("3Sum: " + sol.threeSum(arr6, arr6.length)); // []
    }

}
