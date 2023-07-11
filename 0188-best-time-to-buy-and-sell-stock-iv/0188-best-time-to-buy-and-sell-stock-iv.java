/** DP
* dp[i][j] - refers to the max profit up until prices[j] using within i transactions
* dp[i][j] = max(dp[i][j - 1], prices[j] - prices[jj] + dp[i - 1][jj]) for jj (buy day) in range [0, j-1];
*          = max(dp[i][j - 1], prices[j] + max(dp[i - 1][jj] - prices[jj]) for jj in [0, j-1];
* dp[0][j] = 0, for 0 transaction
* dp[i][0] = 0, if there is only one price, no transaction can be made
*/
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        
        //when k is large, just accumulate all the rising gap
        int maxProfit = 0;
        if (k >= n / 2) {
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) maxProfit += prices[i] - prices[i - 1];
            }
            return maxProfit;
        }
        
        //when k is not large, run the dp
        int[][] dp = new int[k + 1][n];
        int localMax = Integer.MIN_VALUE;
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j < n; j++) {
                localMax = Math.max(localMax, dp[i - 1][j - 1] - prices[j - 1]); 
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
            }
            localMax = Integer.MIN_VALUE; //reset
        }
        return dp[k][n - 1];
    }
}
//Time: O(n * k); Space: O(n * k)
