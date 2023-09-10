package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _417 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, List<Integer>> pac = new HashMap<>();
        Map<String, List<Integer>> atl = new HashMap<>();

        for (int row = 0; row < heights.length; row++) {
            dfs(heights, row, 0, pac, heights[row][0]);
            dfs(heights, row, heights[0].length - 1, atl, heights[row][heights[0].length - 1]);
        }

        for (int col = 0; col < heights[0].length; col++) {
            dfs(heights, 0, col, pac, heights[0][col]);
            dfs(heights, heights.length - 1, col, atl, heights[heights.length - 1][col]);
        }


        for (int row = 0; row < heights.length; row++) {
            for (int col = 0; col < heights[0].length; col++) {
                String rc = "r=" + row + "c" + col;
                if (pac.containsKey(rc) && atl.containsKey(rc)) {
                    res.add(List.of(row, col));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int row, int col, Map<String, List<Integer>> visited, int prevH) {
        if (row < 0 || row >= heights.length || col < 0 || col >= heights[0].length
                || heights[row][col] < prevH) {
            return;
        }
        String rc = "r=" + row + "c" + col;
        if (visited.containsKey(rc)) {
            return;
        }

        visited.put(rc, List.of(row, col));
        dfs(heights, row + 1, col, visited, heights[row][col]);
        dfs(heights, row - 1, col, visited, heights[row][col]);
        dfs(heights, row, col + 1, visited, heights[row][col]);
        dfs(heights, row, col - 1, visited, heights[row][col]);
    }
}
