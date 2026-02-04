package Graphs;

import java.util.Arrays;

public class MaxAreaOfIsland {

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int sol = 1;
        sol += dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1);
        return sol;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int maxArea = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland = new MaxAreaOfIsland();

        // Example 1: Max area = 4 (top-left island)
        int[][] grid1 = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 1 }
        };
        System.out.println("Grid1 max area: " + maxAreaOfIsland.maxAreaOfIsland(grid1)); // 4

        // Print grid1 after (all marked 0)
        System.out.println("Grid1 after:");
        for (int[] row : grid1) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();

        // Example 2: Max area = 6 (big island)
        int[][] grid2 = {
                { 1, 0, 1, 0, 1, 1 },
                { 1, 1, 1, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 1 },
                { 1, 0, 0, 0, 0, 1 },
                { 0, 1, 1, 1, 1, 0 }
        };
        System.out.println("Grid2 max area: " + maxAreaOfIsland.maxAreaOfIsland(grid2)); // 6

        // Print grid2 after (all marked 0)
        System.out.println("Grid2 after:");
        for (int[] row : grid2) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }

}
