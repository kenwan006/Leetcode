/** DP
* dp[i] means the fewest number of coins to make up to the amount i
* dp[i] = min{dp[i], dp[i - coin_j]}
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // need to return dp[amount]
        Arrays.fill(dp, amount + 1); // amount + 1 is the lagest number if choosing 1 every time
        
        //base case
        dp[0] = 0;
        
        for (int i = 1; i < amount + 1; i++) {
            for (int coin : coins) { // check every choice of coins for each amount
                if (i - coin < 0) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] == amount + 1? -1 : dp[amount];
    }
}