class Solution {
    public int maxProfit(int k, int[] prices) {
     /**
        Here are (2k + 1) states:
        0 - no transaction made
        1 - holding a stock after 1 trasaction at the end of ith day
        2 - not holding a stock after 1 trasaction
        .
        .
        .
     2k-1 - holding a stock after k trasactions 
     2k   - not holding a stock after k trasactions
        
        Let j = 1, 3, 5, .. for state of holding stock
        Let j + 1 = 2, 4, 6... for state of not holding stock
        
        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]); //stay or buy at the end of ith day
        dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]); //stay or sell at the end of ith day
        
     **/
        
        int n = prices.length;
        int[][] dp = new int[n][2 * k + 1];
        
        //base case i = 0
        for (int j = 1; j < k * 2; j += 2) {
            dp[0][j] = -prices[0]; // holding a stock at the end of 0th day after (j+1)/2 transactions
            dp[0][j + 1] = 0;  // not holding a stock at the end of 0th day after (j+1)/2 transactions
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k * 2; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[n - 1][2 * k];
    }
}
//Time: O(k * n); Space: O(k * n)

