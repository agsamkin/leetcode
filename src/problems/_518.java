package problems;

public class _518 {
    public static void main(String[] args) {

    }

    public int change(int amount, int[] coins) {

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= amount; j++) {

            }
        }

        return -1;
    }
}
