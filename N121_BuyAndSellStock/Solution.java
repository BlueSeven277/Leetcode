package N121_BuyAndSellStock;

/**
 * Created by srx on 2018/12/27.
 */
class Solution {
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<=1){
            return 0;
        }
        int n = prices.length;
        int[] dp = new int[n];
        dp[n-1]=prices[n-1];
        int max = 0;
        for (int i = n-2;i>=0;i--){
            dp[i] = Integer.max(prices[i],dp[i+1]);
            if (dp[i]-prices[i]>max)
                max = dp[i]-prices[i];

        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = {1,2};
        Solution s = new Solution();
        System.out.print(s.maxProfit(prices));
    }
}