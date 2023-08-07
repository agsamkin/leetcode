package problems;

public class _200 {
    public static void main(String[] args) {
        System.out.println(numIslands(new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        }));
    }

    public static int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    res++;
                    check(grid, i, j+1);
                    check(grid,i+1, j);
                }
            }
        }
        return res;
    }

    public static void check(char[][] grid, int i, int j) {
        if (i >= grid.length || i < 0) {
            return;
        }
        if (j >= grid[i].length || j < 0) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '2';
            check(grid, i, j+1);
            check(grid, i, j-1);
            check(grid, i+1, j);
            check(grid, i-1, j);
        }
    }

}
