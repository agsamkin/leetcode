package problems;

import java.util.HashSet;
import java.util.Set;

public class _217 {
    public static void main(String[] args) {
        var res = containsDuplicate(new int[] {1,2,3,1});
        System.out.println(res);
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
