package Graphs;

import java.util.Arrays;

public class NumberOfIslands {

    private boolean dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return true;
            // - void dfs -
            // return;
        }
        grid[i][j] = '0';
        return dfs(grid, i - 1, j) && dfs(grid, i + 1, j) && dfs(grid, i, j - 1) && dfs(grid, i, j + 1);
        // - remove && and call all 4 dfs calls -
        // dfs(grid, i - 1, j) up
        // dfs(grid, i + 1, j) down
        // dfs(grid, i, j - 1) left
        // dfs(grid, i, j + 1) right
    }

    private int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int islands = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    islands += dfs(grid, i, j) ? 1 : 0;
                    // - void dfs -
                    // islands ++;
                    // dfs(grid, i, j)
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        NumberOfIslands numberOfIslands = new NumberOfIslands();

        // Example 1: 1 island (LeetCode/NeetCode standard)
        char[][] grid1 = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' }
        };
        System.out.println("Grid1 islands: " + numberOfIslands.numIslands(grid1)); // Expected: 1

        // Example 2: 3 islands
        char[][] grid2 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println("Grid2 islands: " + numberOfIslands.numIslands(grid2)); // Expected: 3

        // Print grid1 after processing (should show all '1's as '0')
        System.out.println("Grid1 after:");
        for (char[] row : grid1) {
            System.out.println(Arrays.toString(row));
        }
    }

}
