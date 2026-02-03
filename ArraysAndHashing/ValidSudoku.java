package ArraysAndHashing;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9], col = new int[9], inner_sq = new int[9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if (board[i][j] == '.') continue;

                int d = board[i][j] - '1';
                int mask = 1 << d;
                int k = (i / 3) * 3 + j / 3;
                if(((row[i] & mask) != 0) || ((col[j] & mask) != 0) || (inner_sq[k] & mask) != 0){
                    return false;
                }
                row[i] |= mask;
                col[j] |= mask;
                inner_sq[k] |= mask;
            }
        }
        return true;
        // TC and SC - O(n * n)
        // HashSet<Character>[] rows = new HashSet[9];
        // HashSet<Character>[] cols = new HashSet[9];
        // HashSet<Character>[] boxes = new HashSet[9];
        // for (int i = 0; i < 9; i++) {
        //     rows[i] = new HashSet<>();
        //     cols[i] = new HashSet<>();
        //     boxes[i] = new HashSet<>();
        // }
        // for (int i = 0; i < 9; i++) {
        //     for (int j = 0; j < 9; j++) {
        //         char c = board[i][j];
        //         if (c == '.') continue;
        //         int b = (i / 3) * 3 + j / 3;
        //         if (!rows[i].add(c) || !cols[j].add(c) || !boxes[b].add(c)) {
        //             return false;
        //         }
        //     }
        // }
        // return true;
    }

    
    public static void main(String[] args) {
        char[][] board = {
                            {'1','2','.','.','3','.','.','.','.'},
                            {'4','.','.','5','.','.','.','.','.'},
                            {'.','9','8','.','.','.','.','.','3'},
                            {'5','.','.','.','6','.','.','.','4'},
                            {'.','.','.','8','.','3','.','.','5'},
                            {'7','.','.','.','2','.','.','.','6'},
                            {'.','.','.','.','.','.','2','.','.'},
                            {'.','.','.','4','1','9','.','.','8'},
                            {'.','.','.','.','8','.','.','7','9'}
                        };

        ValidSudoku isValidSudoku = new ValidSudoku();
        System.out.println(isValidSudoku.isValidSudoku(board));


    };
}
