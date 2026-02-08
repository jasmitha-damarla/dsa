package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeElementsBySign {

    // Handles unequal counts: extra elements go at the end
    public int[] rearrangeBySignUnequal(int[] A) {
        int n = A.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Separate positives and negatives
        for (int x : A) {
            if (x >= 0)
                pos.add(x); // treat 0 as positive (common convention)
            else
                neg.add(x);
        }

        int[] ans = new int[n];
        int i = 0, p = 0, q = 0;

        // Start with positive (you can flip this if needed)
        boolean turnPos = true;

        // Alternate while both lists have elements
        while (p < pos.size() && q < neg.size()) {
            if (turnPos) {
                ans[i++] = pos.get(p++);
            } else {
                ans[i++] = neg.get(q++);
            }
            turnPos = !turnPos;
        }

        // Append remaining positives, if any
        while (p < pos.size()) {
            ans[i++] = pos.get(p++);
        }

        // Append remaining negatives, if any
        while (q < neg.size()) {
            ans[i++] = neg.get(q++);
        }

        return ans;
    }

    public int[] rearrangeBySign(int[] A) {
        int n = A.length;

        int[] ans = new int[n];

        int posIndex = 0, negIndex = 1;

        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                ans[negIndex] = A[i];
                negIndex += 2;
            } else {
                ans[posIndex] = A[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        RearrangeElementsBySign sol = new RearrangeElementsBySign();

        // Test case 1: Equal positives and negatives (LeetCode 2149 style)
        int[] arr1 = { 3, 1, -2, -5, 2, -4 };
        System.out.println("Input : " + Arrays.toString(arr1));
        int[] res1 = sol.rearrangeBySign(arr1);
        System.out.println("Output: " + Arrays.toString(res1)); // [3,-2,1,-5,2,-4]
        System.out.println();

        // Test case 2: Another balanced case
        int[] arr2 = { 1, -1, 2, -2 };
        System.out.println("Input : " + Arrays.toString(arr2));
        int[] res2 = sol.rearrangeBySign(arr2);
        System.out.println("Output: " + Arrays.toString(res2)); // [1,-1,2,-2]
        System.out.println();

        // Test case 3: Only positives (will fill even indices first, odds stay 0)
        int[] arr3 = { 1, 2, 3, 4 };
        System.out.println("Input : " + Arrays.toString(arr3));
        int[] res3 = sol.rearrangeBySign(arr3);
        System.out.println("Output: " + Arrays.toString(res3)); // [1,0,2,0] due to logic
        System.out.println();

        // Test case 4: Only negatives
        int[] arr4 = { -1, -2, -3, -4 };
        System.out.println("Input : " + Arrays.toString(arr4));
        int[] res4 = sol.rearrangeBySign(arr4);
        System.out.println("Output: " + Arrays.toString(res4)); // [0,-1,0,-2]
    }
}
