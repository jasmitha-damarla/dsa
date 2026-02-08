package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithSumK {

    public int subarraySum(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int prefixSum = 0;

        // Map: prefixSum -> frequency
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // base case: prefix sum 0 seen once

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // We want prefixSum - k to have appeared before
            int need = prefixSum - k;
            if (map.containsKey(need)) {
                count += map.get(need);
            }

            // Record current prefixSum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }

    // Simple main to test
    public static void main(String[] args) {
        CountSubarrayWithSumK sol = new CountSubarrayWithSumK();

        int[] a1 = { 1, 1, 1 };
        int k1 = 2;
        System.out.println("Count (a1,k1): " + sol.subarraySum(a1, k1)); // 2 -> [1,1] at (0,1) and (1,2)

        int[] a2 = { 1, 2, 3 };
        int k2 = 3;
        System.out.println("Count (a2,k2): " + sol.subarraySum(a2, k2)); // 2 -> [1,2], [3]

        int[] a3 = { 1, -1, 1, -1, 1 };
        int k3 = 1;
        System.out.println("Count (a3,k3): " + sol.subarraySum(a3, k3)); // multiple subarrays of sum 1

        int[] a4 = { 3, 4, 7, 2, -3, 1, 4, 2 };
        int k4 = 7;
        System.out.println("Count (a4,k4): " + sol.subarraySum(a4, k4)); // 4
    }
}
