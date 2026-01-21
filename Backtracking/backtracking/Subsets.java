package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, sol);
        return sol;
    }

    public void dfs(int[] nums, int cur, List<Integer> subset, List<List<Integer>> sol) {
        if (cur >= nums.length) {
            sol.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[cur]);
        dfs(nums, cur + 1, subset, sol);
        subset.remove(subset.size() - 1);
        dfs(nums, cur + 1, subset, sol);
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        subsets.subsets(new int[] { 1, 2, 3 }).forEach(System.out::println);
    }
}
