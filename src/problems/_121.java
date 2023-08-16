package problems;

public class _121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }

    public static int maxProfit(int[] prices) {
        int l = 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[l]) {
                max = Math.max(max, prices[i] - prices[l]);
            } else {
                l = i;
            }
        }
        return max;
    }
}
