package problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class _994 {
    public static void main(String[] args) {
        int res = orangesRotting(new int[][]{
                {1,2},
        });
        System.out.println(res);
    }

    public static int orangesRotting(int[][] grid) {
       if (grid.length == 0 || grid[0].length == 0) {
           return 0;
       }

        Deque<Cell> deque = new ArrayDeque<>();
       int freshOrange = 0;
       for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 2) {
                    deque.addLast(new Cell(row, col, 0));
                } else if (grid[row][col] == 1) {
                    freshOrange++;
                }
            }
        }

        if (deque.isEmpty() && freshOrange == 0) {
            return 0;
        } else if (deque.isEmpty() && freshOrange > 0) {
            return -1;
        }

        int min = -1;
        while (!deque.isEmpty()) {
            int s = deque.size();
            for (int i = 0; i < s; i++) {
                Cell cell = deque.pollFirst();
                if (grid[cell.row][cell.col] == 1 || cell.path == 0) {
                    min = cell.path;
                    grid[cell.row][cell.col] = 2;
                    if (cell.path > 0) {
                        freshOrange--;
                    }

                    if (cell.row + 1 < grid.length) {
                        deque.addLast(new Cell(cell.row + 1, cell.col, cell.path + 1));
                    }
                    if (cell.row - 1 >= 0) {
                        deque.addLast(new Cell(cell.row - 1, cell.col, cell.path + 1));
                    }
                    if (cell.col + 1 < grid[cell.row].length) {
                        deque.addLast(new Cell(cell.row, cell.col + 1, cell.path + 1));
                    }
                    if (cell.col - 1 >= 0) {
                        deque.addLast(new Cell(cell.row, cell.col - 1, cell.path + 1));
                    }
                }
            }
        }


        return min == Integer.MAX_VALUE || freshOrange > 0 ? -1 : min;
    }

    static class Cell {
        int row;
        int col;
        int path;

        public Cell(int row, int col, int path) {
            this.row = row;
            this.col = col;
            this.path = path;
        }
    }

}
