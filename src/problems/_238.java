package problems;

import java.util.Arrays;

public class _238 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[] {1,2,3,4})));
    }


    public static int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            left *= i == 0 ? left : nums[i-1];
            res[i] = left;
        }

        int right = 1;
        for (int i = res.length-2; i >= 0; i--) {
            right *= nums[i+1];
            res[i] *= right;
        }

        return res;

    }

    public static int[] _productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < res.length; i++) {
            int mul = 1;
            for (int j = 0; j < res.length; j++) {
                if (i == j) {
                    continue;
                }
                mul *= nums[j];
            }
            res[i] = mul;
        }
        return res;
    }
}
