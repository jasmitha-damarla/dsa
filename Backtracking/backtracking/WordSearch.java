package backtracking;

public class WordSearch {

    private int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }

        board[r][c] = '#';

        boolean sol = dfs(board, word, r + 1, c, i + 1) ||
                dfs(board, word, r - 1, c, i + 1) ||
                dfs(board, word, r, c + 1, i + 1) ||
                dfs(board, word, r, c - 1, i + 1);
        board[r][c] = word.charAt(i);

        return sol;
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();

        // Test case 1: Standard example where word exists
        char[][] board1 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word1 = "ABCCED";
        System.out.println("Test 1: " + solution.exist(board1, word1)); // Expected: true

        // Test case 2: Word exists
        String word2 = "SEE";
        System.out.println("Test 2: " + solution.exist(board1, word2)); // Expected: true

        // Test case 3: Word does not exist
        String word3 = "ABCB";
        System.out.println("Test 3: " + solution.exist(board1, word3)); // Expected: false

    }

}
