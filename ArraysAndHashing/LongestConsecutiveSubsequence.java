package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestConsecutiveSubsequence {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for(int num : nums){
            if(!map.containsKey(num)){
                int prev = map.getOrDefault(num - 1, 0);
                int next = map.getOrDefault(num + 1, 0);
                int curLen = prev + next + 1;
                map.put(num, curLen);
                map.put(num - prev, curLen);
                map.put(num + next, curLen);
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        LongestConsecutiveSubsequence longestConsecutiveSubsequence = new LongestConsecutiveSubsequence();
        System.out.println(longestConsecutiveSubsequence.longestConsecutive(arr));
    }
}
