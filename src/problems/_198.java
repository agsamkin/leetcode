package problems;

import java.util.Arrays;

public class _198 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {1,2,3,1}));
    }
    public static int rob(int[] nums) {
        if (nums.length < 3) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }
        nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
        }

        return Math.max(nums[nums.length-1], nums[nums.length-2]);
    }
}
