package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _322 {

    public static void main(String[] args) {
        System.out.println(coinChange(new int[] {186,419,83,408}, 6249));
        //System.out.println(coinChange(new int[] {411,412,413,414,415,416,417,418,419,420,421,422}, 9864));
        System.out.println(coinChange(new int[] {1,2,5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }    
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
    

}
