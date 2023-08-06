package problems;

public class _121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {3,6,2,7,1}));
    }

    public static int maxProfit(int[] prices) {
        int l = 0;
        int r = 1;

        int max = 0;
        while (r < prices.length) {
            if (prices[l] > prices[r]) {
                l = r;
                r++;
            } else {
                max = Math.max(max, prices[r]-prices[l]);
                r++;
            }
        }
        return max;
    }
}
