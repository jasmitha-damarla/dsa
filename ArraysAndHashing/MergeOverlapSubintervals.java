package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeOverlapSubintervals {

    public List<List<Integer>> merge(int[][] intervals) {
        if (intervals.length <= 1)
            return new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<List<Integer>> merge = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merge.isEmpty() || merge.get(merge.size() - 1).get(1) < interval[0]) {
                merge.add(Arrays.asList(interval[0], interval[1]));
            } else {
                merge.get(merge.size() - 1)
                        .set(1,
                                Math.max(merge.get(merge.size() - 1).get(1),
                                        interval[1]));
            }
        }
        return merge;
    }

    public static void main(String[] args) {
        MergeOverlapSubintervals sol = new MergeOverlapSubintervals();

        // Test case 1: LeetCode classic
        int[][] intervals1 = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        System.out.println("intervals1: " + Arrays.deepToString(intervals1));
        System.out.println("Merged: " + sol.merge(intervals1)); // [[1,6],[8,10],[15,18]]
        System.out.println();

        // Test case 2: All overlapping
        int[][] intervals2 = { { 1, 4 }, { 4, 5 } };
        System.out.println("intervals2: " + Arrays.deepToString(intervals2));
        System.out.println("Merged: " + sol.merge(intervals2)); // [[1,5]]
        System.out.println();

        // Test case 3: No overlap
        int[][] intervals3 = { { 1, 4 }, { 5, 6 } };
        System.out.println("intervals3: " + Arrays.deepToString(intervals3));
        System.out.println("Merged: " + sol.merge(intervals3)); // [[1,4],[5,6]]
        System.out.println();

        // Test case 4: Single interval
        int[][] intervals4 = { { 1, 4 } };
        System.out.println("intervals4: " + Arrays.deepToString(intervals4));
        System.out.println("Merged: " + sol.merge(intervals4)); // [[1,4]]
        System.out.println();

        // Test case 5: Empty
        int[][] intervals5 = {};
        System.out.println("intervals5: " + Arrays.deepToString(intervals5));
        System.out.println("Merged: " + sol.merge(intervals5)); // []
        System.out.println();

        // Test case 6: Touching intervals
        int[][] intervals6 = { { 2, 3 }, { 2, 3 }, { 3, 3 } };
        System.out.println("intervals6: " + Arrays.deepToString(intervals6));
        System.out.println("Merged: " + sol.merge(intervals6)); // [[2,3]]
        System.out.println();

        // Test case 7: Nested intervals
        int[][] intervals7 = { { 1, 4 }, { 2, 3 } };
        System.out.println("intervals7: " + Arrays.deepToString(intervals7));
        System.out.println("Merged: " + sol.merge(intervals7)); // [[1,4]]
    }
}
