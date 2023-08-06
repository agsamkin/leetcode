package problems;

import java.util.Arrays;

public class _167 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[] {3,24,50,79,88,150,345}, 200)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (numbers[right] + numbers[left] != target) {
            if (numbers[right] + numbers[left] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[] {++left, ++right};
    }
}
