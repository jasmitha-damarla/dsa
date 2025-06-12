package ArraysAndHashing;

import java.util.Scanner;

public class ValidAnagram {

    public boolean isValidAnagram(String a, String b){
        if(a.length() != b.length()){
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < a.length(); i++){
            count[a.charAt(i)-'a']++;
            count[b.charAt(i)-'a']--;
        }
        for(int val :  count){
            if(val != 0){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String s) {
        int i = 0, N = s.length()-1;
        int j = N;
        while(i < j){
            char fch = s.charAt(i);
            char lch = s.charAt(j);
            if(!(fch>=65 && fch<=90) || (fch>=97 && fch<=122) || (fch>=48 && fch<=56)){
                i++;
                continue;
            }
            if(!(lch>=65 && lch<=90) || (lch>=97 && lch<=122) || (lch>=48 && lch<=56)){
                 j--;
                 continue;
            }
            if(Character.toLowerCase(fch)!=Character.toLowerCase(lch)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isValidAnagram(a, b));
    }
    
}
