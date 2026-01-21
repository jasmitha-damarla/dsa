package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    List<List<Integer>> permutations;

    public List<List<Integer>> permute(int[] nums) {
        permutations = new ArrayList<>();
        backtrack(nums, new boolean[nums.length], new ArrayList<>());
        return permutations;
    }

    public void backtrack(int[] nums, boolean[] visit, List<Integer> cur) {
        if (cur.size() == nums.length) {
            permutations.add(new ArrayList<>(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visit[i]) {
                cur.add(nums[i]);
                visit[i] = true;
                backtrack(nums, visit, cur);
                cur.remove(cur.size() - 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        permutations.permute(new int[] { 1, 2, 3 }).forEach(System.out::println);
    }

}
