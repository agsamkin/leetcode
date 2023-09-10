package problems;

public class _695 {
    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    grid[row][col] = 2;
                    int[] s = new int[] {1};
                    dfs(grid, row + 1, col, s);
                    dfs(grid, row, col + 1, s);
                    max = Math.max(max, s[0]);
                }
            }
        }
        return max;
    }

    private void dfs(int[][] grid, int row, int col, int[] s) {
        if (row < 0 || row >= grid.length) {
            return;
        }
        if (col < 0 || col >= grid[0].length) {
            return;
        }
        if (grid[row][col] == 1) {
            grid[row][col] = 2;
            s[0] += 1;
            dfs(grid, row,col + 1, s);
            dfs(grid, row,col - 1, s);
            dfs(grid, row + 1, col, s);
            dfs(grid, row - 1, col, s);
        }
    }
}
