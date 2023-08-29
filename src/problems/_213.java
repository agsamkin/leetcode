package problems;

import javax.swing.*;
import java.util.Arrays;

public class _213 {
    public static void main(String[] args) {
        System.out.println(rob(new int[] {200,3,140,20,10}));
    }
    public static int rob(int[] nums) {
        if (nums.length < 3) {
            Arrays.sort(nums);
            return nums[nums.length - 1];
        }

        int[] dp1 = new int[nums.length - 1];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < dp1.length; i++) {
            dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
        }

        int[] dp2 = new int[nums.length - 1];
        dp2[0] = nums[1];
        dp2[1] = Math.max(nums[1], nums[2]);
        for (int i = 2; i < dp2.length; i++) {
            dp2[i] = Math.max(nums[i+1] + dp2[i - 2], dp2[i - 1]);
        }

        return Math.max(dp1[dp1.length-1], dp2[dp2.length-1]);
    }

}
