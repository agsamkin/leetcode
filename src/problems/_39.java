package problems;

import java.util.ArrayList;
import java.util.List;

public class _39 {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[] {2,3,6,7}, 7));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        getCombination(candidates, target, combination, new ArrayList<>(), 0, 0);
        return combination;
    }

    public static void getCombination(int[] candidates, int target, List<List<Integer>> combination, List<Integer> tmp,
                                      int index, int curr) {
        if (curr == target) {
            combination.add(new ArrayList<>(tmp));
            return;
        }

        if (index >= candidates.length || curr > target) {
            return;
        }

        tmp.add(candidates[index]);

        getCombination(candidates, target, combination, tmp, index, curr + candidates[index]);

        tmp.remove(tmp.size()-1);
        getCombination(candidates, target, combination, tmp, index + 1, curr);

    }

}
