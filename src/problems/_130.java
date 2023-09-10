package problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class _130 {
    public static void main(String[] args) {
        solve(new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        });
    }

    public static void solve(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == 'O') {
                    Set<String> visited = new HashSet<>();
                    if (check(board, visited, row, col)) {
                        board[row][col] = 'X';
                        Iterator<String> iter = visited.iterator();
                        while (iter.hasNext()) {
                            String[] rc = iter.next().split(":");
                            int r = Integer.parseInt(rc[0]);
                            int c = Integer.parseInt(rc[1]);
                            board[r][c] = 'X';
                        }
                    };
                }
            }
        }

    }

    private static boolean check(char[][] board, Set<String> visited, int row, int col) {
        if (row < 0 || row >= board.length
                || col < 0 || col >= board[row].length) {
            return false;
        }

        String mark = "" + row + ":" + col;
        if (visited.contains(mark)) {
            return true;
        }
        visited.add(mark);

        if (board[row][col] == 'X') {
            return true;
        }
        if (board[row][col] == 'O') {
            return check(board, visited, row + 1, col)
                    && check(board, visited,row - 1, col)
                    && check(board, visited, row, col + 1)
                    && check(board, visited, row, col - 1);
//                    && check(board, visited, row + 1, col - 1)
//                    && check(board, visited, row + 1, col + 1)
//                    && check(board, visited, row - 1, col - 1)
//                    && check(board, visited, row - 1, col + 1);
        }
        return true;
    }
}
