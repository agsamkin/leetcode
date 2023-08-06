package problems;

import java.util.HashSet;
import java.util.Set;

public class _36 {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char ch = board[i][j];
                if (ch == '.') {
                    continue;
                }
                if (!set.add("row" + i + ch)
                || !set.add("col" + j + ch)
                || !set.add("block"+i/3+"-"+j/3+ch)) {
                    return false;
                }
            }
        }
        return true;
    }
}
