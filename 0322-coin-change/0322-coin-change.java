class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; 
        Arrays.fill(dp, amount + 1); //set initial val to be large
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (coin > i) continue;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] > amount?  -1 : dp[amount];
    }
}
//Time: O(m * n); Space: O(n)

