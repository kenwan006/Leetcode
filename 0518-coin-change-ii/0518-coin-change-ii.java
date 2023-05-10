/** dp **/
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        
        //for (int j = 1; j <= amount; j++) dp[0][j] = 0; //nothing to choose
        for (int i = 0; i <= n; i++) dp[i][0] = 1; //volume is 0
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    //do not use dp[i][j] = dp[i - 1][j] + dp[i - 1][j - coins[i - 1]] as ith conin - coins[i - 1] can be used unlimited times
                }
            }
        }
        return dp[n][amount];
    }
}
//Time: O(m * n); Space: O(m * n)
