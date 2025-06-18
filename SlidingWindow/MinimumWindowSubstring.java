package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if(t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for(char ch : t.toCharArray()) {
            countT.put(ch, countT.getOrDefault(ch, 0) + 1);
        }
        int have = 0, need = countT.size(), l = 0;
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            if(countT.containsKey(ch) && window.get(ch).equals(countT.get(ch))) {
                have++;
            }

            while(have == need) {
                if((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char lch = s.charAt(l);
                window.put(lch, window.get(lch) - 1);
                if(countT.containsKey(lch) && window.get(lch) < countT.get(lch)) {
                    have--;
                }
                l++;
            }
        }
        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring minimumWindowSubstring = new MinimumWindowSubstring();
        Scanner scanner = new Scanner(System.in);
        String str1  = scanner.nextLine();
        String str2  = scanner.nextLine();
        
        System.out.println(minimumWindowSubstring.minWindow(str1, str2));
    }
    
}
