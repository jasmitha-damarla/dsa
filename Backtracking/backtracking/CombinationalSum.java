package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {

    List<List<Integer>> sol;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        sol = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, nums, 0, new ArrayList<>(), target);
        return sol;
    }

    public void dfs(int i, int[] nums, int cur, List<Integer> subset, int target) {
        if (cur == target) {
            sol.add(new ArrayList<>(subset));
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (cur + nums[j] > target) {
                return;
            }
            subset.add(nums[j]);
            dfs(j, nums, cur + nums[j], subset, target);
            subset.remove(subset.size() - 1);
        }

    }

    public static void main(String[] args) {
        CombinationalSum combinationalSum = new CombinationalSum();
        combinationalSum.combinationSum(new int[] { 1, 2, 3 }, 6).forEach(System.out::println);
    }
}
