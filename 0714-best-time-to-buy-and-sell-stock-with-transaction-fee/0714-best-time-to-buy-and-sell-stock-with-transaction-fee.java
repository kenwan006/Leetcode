class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        /**
         Here are two states:
         0 - holding a stock at the end of ith day
         1 - not holding a stock at the end of ith day
        
        */
        int[][] dp = new int[n][2]; 
        
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
          
    }
}
//Time: O(n); Space: O(n)
