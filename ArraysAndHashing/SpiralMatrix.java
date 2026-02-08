package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        if (m == 0)
            return res;
        int n = matrix[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // 1. Left → Right along top row
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }
            top++;

            // 2. Top → Bottom along right column
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;

            // 3. Right → Left along bottom row (if still valid)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            // 4. Bottom → Top along left column (if still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SpiralMatrix sol = new SpiralMatrix();

        int[][] m1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Matrix 1:");
        for (int[] row : m1)
            System.out.println(Arrays.toString(row));
        System.out.println("Spiral: " + sol.spiralOrder(m1)); // [1,2,3,6,9,8,7,4,5]
        System.out.println();

        int[][] m2 = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 }
        };
        System.out.println("Matrix 2:");
        for (int[] row : m2)
            System.out.println(Arrays.toString(row));
        System.out.println("Spiral: " + sol.spiralOrder(m2)); // [1,2,3,4,8,12,11,10,9,5,6,7]
        System.out.println();

        int[][] m3 = {
                { 1 },
        };
        System.out.println("Matrix 3:");
        for (int[] row : m3)
            System.out.println(Arrays.toString(row));
        System.out.println("Spiral: " + sol.spiralOrder(m3)); // [1]
    }
}
