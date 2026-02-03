package SlidingWindow;

import java.util.Scanner;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int l = 0, r, N1 = s1.length(), N2 = s2.length(), matches = 0;
    
        int[] s1count = new int[26];
        int[] s2count = new int[26];


        for(int i = 0; i < N1; i++){
            s1count[s1.charAt(i) - 'a'] += 1;
            s2count[s2.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < 26; i++){
            if(s1count[i] == s2count[i]){
                matches++;
            }
        }
        r = N1;
        while(r < N2) {
            if(matches == 26){
                return true;
            }
            int idx = s2.charAt(r) - 'a';
            s2count[idx]++;
            if(s1count[idx] == s2count[idx]) {
                matches++;
            } else if(s1count[idx] + 1 == s2count[idx]){
                matches--;
            }

            idx = s2.charAt(l) - 'a';
            s2count[idx]--;
            if(s1count[idx] == s2count[idx]) {
                matches++;
            } else if(s1count[idx] - 1 == s2count[idx]){
                matches--;
            }
            l++;
            r++;
        }

        return matches == 26;
    }

    public static void main(String[] args) {
        PermutationInString permutationInString = new PermutationInString();
        Scanner scanner = new Scanner(System.in);
        String str1  = scanner.nextLine();
        String str2  = scanner.nextLine();
        
        System.out.println(permutationInString.checkInclusion(str1, str2));
    }
    
}
