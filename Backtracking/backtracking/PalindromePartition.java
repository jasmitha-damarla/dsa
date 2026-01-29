package backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    public List<List<String>> partition(String s) {
        List<List<String>> sol = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        dfs(0, s, partition, sol);
        return sol;
    }

    private void dfs(int cur, String s, List<String> partition, List<List<String>> sol) {
        if (cur >= s.length()) {
            sol.add(new ArrayList<>(partition));
            return;
        }

        for (int i = cur; i < s.length(); i++) {
            if (isPalindrome(s, cur, i)) {
                partition.add(s.substring(cur, i + 1));
                dfs(i + 1, s, partition, sol);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromePartition palindromePartition = new PalindromePartition();
        palindromePartition.partition("aaab").forEach(System.out::println);
    }
}
