package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestUniqueSubstring {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, l = 0, r = 0, N = s.length();
        while(r < N){
            if(map.containsKey(s.charAt(r))){
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r); 
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
            
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        LongestUniqueSubstring longestUniqueSubstring = new LongestUniqueSubstring();
        System.out.println(longestUniqueSubstring.lengthOfLongestSubstring(s));
    }
    
}
