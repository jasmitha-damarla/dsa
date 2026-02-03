package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {

    List<List<Integer>> sol = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>());
        return sol;
    }

    public void dfs(int[] nums, int cur, List<Integer> subset) {
        sol.add(new ArrayList<>(subset));
        for (int j = cur; j < nums.length; j++) {
            if (j > cur && nums[j] == nums[j - 1]) {
                continue;
            }
            subset.add(nums[j]);
            dfs(nums, j + 1, subset);
            subset.remove(subset.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets2 subsets = new Subsets2();
        subsets.subsets(new int[] { 1, 2, 3 }).forEach(System.out::println);
    }

}
