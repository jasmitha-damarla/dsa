package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int maxLen = 0, l = 0, r = 0, N = s.length(), freq = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r < N) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);
            freq = Math.max(freq, map.get(s.charAt(r)));
            while((r - l + 1) - freq > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement characterReplacement = new LongestRepeatingCharacterReplacement();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.next();
        int k = scanner.nextInt();
        System.out.println(characterReplacement.characterReplacement(str, k));
    }
    
}
