package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LeadersInArray {

    public ArrayList<Integer> leaders(int[] nums) {
        ArrayList<Integer> sol = new ArrayList<>();
        int maxEle = Integer.MIN_VALUE, N = nums.length;
        for (int i = N - 1; i >= 0; i--) {
            if (nums[i] > maxEle) {
                sol.add(nums[i]);
            }
            maxEle = Math.max(maxEle, nums[i]);
        }
        Collections.reverse(sol);
        return sol;
    }

    public static void main(String[] args) {
        LeadersInArray sol = new LeadersInArray();

        int[] arr1 = { 16, 17, 4, 3, 5, 2 };
        System.out.println("arr1: " + Arrays.toString(arr1));
        System.out.println("Leaders: " + sol.leaders(arr1)); // [17, 5, 2]

        int[] arr2 = { 4, 7, 1, 0 };
        System.out.println("arr2: " + Arrays.toString(arr2));
        System.out.println("Leaders: " + sol.leaders(arr2)); // [7, 1, 0]

        int[] arr3 = { 1, 2, 3, 4, 0 };
        System.out.println("arr3: " + Arrays.toString(arr3));
        System.out.println("Leaders: " + sol.leaders(arr3)); // [4, 0]

        int[] arr4 = { 5 };
        System.out.println("arr4: " + Arrays.toString(arr4));
        System.out.println("Leaders: " + sol.leaders(arr4)); // [5]
    }
}
