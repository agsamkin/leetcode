package problems;

public class _55 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[] {1,1,1,0}));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int cur_len = nums[0];
        if (cur_len == 0) {
            return false;
        }

        for (int i = 1; i < nums.length; i++) {
            if (i == nums.length - 1) {
                return true;
            }

            if (nums[i] >= cur_len) {
                cur_len = nums[i];
            } else {
                cur_len--;
            }

            if (cur_len <= 0) {
                return false;
            }

        }
        return false;
    }
}
