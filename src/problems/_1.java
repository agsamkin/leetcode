package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class _1 {
    public static void main(String[] args) {
//        Input: nums = [2,7,11,15], target = 9
//        Input: nums = [3,2,4], target = 6
        System.out.println(Arrays.toString(twoSum(new int[] {2,7,11,15}, 9)));
    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int prev = target - curr;
            if (map.containsKey(prev)) {
                return new int[] {map.get(prev), i};
            }
            map.put(curr, i);
        }
        return new int[] {-1,-1};
    }
}
