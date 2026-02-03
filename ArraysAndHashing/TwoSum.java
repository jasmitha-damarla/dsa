package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TwoSum {

    public int[] twoSum(int[] nums, int n, int val){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int diff = val - nums[i];
            if(map.containsKey(diff)){
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1};
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        TwoSum twoSum = new TwoSum();
        for(int val : twoSum.twoSum(arr, n, k)){
            System.out.println(val);
        }

    }
    
}
