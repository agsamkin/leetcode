package problems;

public class _11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {2,3,4,5,18,17,6}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxS = 0;
        while (left < right) {
            int s = Math.min(height[left], height[right]) * (right-left);
            maxS = Math.max(maxS, s);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxS;
    }
}
