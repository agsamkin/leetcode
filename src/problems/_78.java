package problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class _78 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[] {1,2,3}));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        List<Integer> tmp = new ArrayList<>();
        backtrack(nums, res, tmp, 0);

        return res;
    }

    private static void backtrack(int[] nums, List<List<Integer>> res, List<Integer> tmp, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(tmp));
            System.out.println(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[i]);
        backtrack(nums, res, tmp, i + 1);

        tmp.remove(tmp.size() - 1);
        backtrack(nums, res, tmp, i + 1);

    }
}
