package problems;

import java.util.ArrayList;
import java.util.List;

public class _46 {
    public static void main(String[] args) {
        var res = permute(new int[] {1,2,3});
        System.out.println(res);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        find(nums, res, new ArrayList<>(), freq);
        return res;
    }

    public static void find(int[] nums, List<List<Integer>> res, List<Integer> tmp, boolean[] freq) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!freq[i]) {
                freq[i] = true;
                tmp.add(nums[i]);
                find(nums, res, tmp, freq);
                tmp.remove(tmp.size()-1);
                find(nums, res, tmp, freq);
                freq[i] = false;
            }
        }
    }
}
