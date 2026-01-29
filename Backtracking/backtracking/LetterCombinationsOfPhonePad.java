package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhonePad {

    private List<String> sol = new ArrayList<>();
    private String[] digitToChar = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return sol;
        }
        backtrack(0, "", digits);
        return sol;
    }

    private void backtrack(int cur, String curString, String digits) {
        if (curString.length() == digits.length()) {
            sol.add(curString);
            return;
        }
        System.out.println("Before: " + curString + ", cur " + cur);
        String chars = digitToChar[digits.charAt(cur) - '0'];
        for (char c : chars.toCharArray()) {
            System.out.println("In Loop: " + curString + ", c " + c + ", cur " + cur);
            backtrack(cur + 1, curString + c, digits);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhonePad combinationsOfPhonePad = new LetterCombinationsOfPhonePad();
        combinationsOfPhonePad.letterCombinations("23").forEach(System.out::println);
    }

}
