package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    List<List<Integer>> sol;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        sol = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(0, candidates, 0, new ArrayList<>(), target);
        return sol;
    }

    public void dfs(int i, int[] candidates, int cur, List<Integer> subset, int target) {
        if (cur == target) {
            sol.add(new ArrayList<>(subset));
            return;
        }

        if (cur > target || i == candidates.length) {
            return;
        }

        subset.add(candidates[i]);
        dfs(i + 1, candidates, cur + candidates[i], subset, target);
        subset.remove(subset.size() - 1);

        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(i + 1, candidates, cur, subset, target);

    }

    public static void main(String[] args) {
        CombinationalSum combinationalSum = new CombinationalSum();
        combinationalSum.combinationSum(new int[] { 1, 2, 3 }, 6).forEach(System.out::println);
    }

}
