package ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public List<Integer> findPascalElement(int r) {

        List<Integer> row = new ArrayList<>();

        if (r == 0) {
            return row;
        }

        row.add(1);

        int comp = 1;
        for (int i = 1; i < r; i++) {
            comp *= (r - i);
            comp /= i;
            row.add(comp);
        }
        return row;
    }

    public List<List<Integer>> generatePascalTriangle(int N) {
        List<List<Integer>> sol = new ArrayList<>();

        if (N == 0) {
            return sol;
        }

        for (int i = 1; i <= N; i++) {
            sol.add(findPascalElement(i));
        }
        return sol;
    }

    public static void main(String[] args) {
        PascalTriangle sol = new PascalTriangle();

        // Test single rows
        System.out.println("Row 1 (r=1): " + sol.findPascalElement(1)); // [1]
        System.out.println("Row 2 (r=2): " + sol.findPascalElement(2)); // [1,1]
        System.out.println("Row 3 (r=3): " + sol.findPascalElement(3)); // [1,2,1]
        System.out.println("Row 4 (r=4): " + sol.findPascalElement(4)); // [1,3,3,1]
        System.out.println("Row 5 (r=5): " + sol.findPascalElement(5)); // [1,4,6,4,1]
        System.out.println();

        // Test full triangle N=5
        System.out.println("Full Pascal Triangle (N=5):");
        List<List<Integer>> triangle = sol.generatePascalTriangle(5);
        for (int i = 0; i < triangle.size(); i++) {
            System.out.println("Row " + (i + 1) + ": " + triangle.get(i));
        }
        System.out.println();

        // Test edge cases
        System.out.println("Edge r=0 (should handle): " + sol.findPascalElement(0)); // Empty or [1]?
    }
}
