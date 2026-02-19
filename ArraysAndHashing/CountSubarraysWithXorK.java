package ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithXorK {

    public int countSubarrays(int[] A, int k) {
        int xor = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < A.length; i++) {
            xor ^= A[i];
            int x = xor ^ k;
            if (map.containsKey(x)) {
                count += map.get(x);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        CountSubarraysWithXorK sol = new CountSubarraysWithXorK();

        // Test case 1: GFG Classic [web:77]
        int[] A1 = { 4, 2, 2, 6, 4 };
        int k1 = 6;
        System.out.println("A1: " + Arrays.toString(A1));
        System.out.println("k=6, Count: " + sol.countSubarrays(A1, k1)); // 4
        System.out.println();

        // Test case 2: k=0 (total subarrays where XOR=0)
        int[] A2 = { 1, 2, 3 };
        int k2 = 0;
        System.out.println("A2: " + Arrays.toString(A2));
        System.out.println("k=0, Count: " + sol.countSubarrays(A2, k2)); // 0
        System.out.println();

        // Test case 3: All elements = k
        int[] A3 = { 6, 6, 6 };
        int k3 = 6;
        System.out.println("A3: " + Arrays.toString(A3));
        System.out.println("k=6, Count: " + sol.countSubarrays(A3, k3)); // 6
        System.out.println();

        // Test case 4: Prefix XOR match
        int[] A4 = { 1, 2, 3, 4 };
        int k4 = 7; // 1^2^4 = 7 (indices 0-3 XOR)
        System.out.println("A4: " + Arrays.toString(A4));
        System.out.println("k=7, Count: " + sol.countSubarrays(A4, k4)); // 1
        System.out.println();

        // Test case 5: Multiple matches
        int[] A5 = { 5, 3, 7, 2, 4 };
        int k5 = 5;
        System.out.println("A5: " + Arrays.toString(A5));
        System.out.println("k=5, Count: " + sol.countSubarrays(A5, k5)); // 3
        System.out.println();

        // Test case 6: Single element
        int[] A6 = { 10 };
        int k6 = 10;
        System.out.println("A6: " + Arrays.toString(A6));
        System.out.println("k=10, Count: " + sol.countSubarrays(A6, k6)); // 1
        System.out.println();

        // Test case 7: Empty array
        int[] A7 = {};
        int k7 = 0;
        System.out.println("A7: " + Arrays.toString(A7));
        System.out.println("k=0, Count: " + sol.countSubarrays(A7, k7)); // 0
        System.out.println();

        // Test case 8: k not present
        int[] A8 = { 1, 1, 1 };
        int k8 = 2;
        System.out.println("A8: " + Arrays.toString(A8));
        System.out.println("k=2, Count: " + sol.countSubarrays(A8, k8)); // 0
    }
}
