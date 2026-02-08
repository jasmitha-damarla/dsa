package ArraysAndHashing;

import java.util.Arrays;

public class RotateImageBy90 {

    public void rotateClockwise(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            reverseAnArray(matrix[i], 0, n - 1);
        }
    }

    private void swap(int[] arr, int x, int y) {
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] = t;
    }

    private void reverseAnArray(int[] arr, int l, int r) {
        while (l < r) {
            swap(arr, l, r);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        RotateImageBy90 sol = new RotateImageBy90();

        int[][] m1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println("Before:");
        for (int[] row : m1)
            System.out.println(Arrays.toString(row));
        sol.rotateClockwise(m1);
        System.out.println("After (90° clockwise):");
        for (int[] row : m1)
            System.out.println(Arrays.toString(row));
        System.out.println();
        // Expected:
        // [7,4,1]
        // [8,5,2]
        // [9,6,3]

        int[][] m2 = {
                { 5, 1, 9, 11 },
                { 2, 4, 8, 10 },
                { 13, 3, 6, 7 },
                { 15, 14, 12, 16 }
        };
        System.out.println("Before:");
        for (int[] row : m2)
            System.out.println(Arrays.toString(row));
        sol.rotateClockwise(m2);
        System.out.println("After (90° clockwise):");
        for (int[] row : m2)
            System.out.println(Arrays.toString(row));
        // Expected:
        // [15,13,2,5]
        // [14,3,4,1]
        // [12,6,8,9]
        // [16,7,10,11]
    }
}
