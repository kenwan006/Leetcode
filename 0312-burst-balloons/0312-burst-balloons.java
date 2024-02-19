class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] arrs = new int[n];
        for (int i = 0; i < nums.length; i++) arrs[i + 1] = nums[i];
        arrs[0] = 1;
        arrs[n - 1] = 1;
        
        int[][] dp = new int[n][n];
        
        for (int len = 1; len <= n - 2; len++) {
            for (int lo = 1; lo < n - len; lo++) {
                int hi = lo + len - 1;
                int coins = 0;
                for (int i = lo; i <= hi; i++) { // i - the last balloon to burst among [lo, hi]
                    int gain = arrs[lo - 1] * arrs[i] * arrs[hi + 1];
                    coins = dp[lo][i - 1] + gain + dp[i + 1][hi];
                    
                    dp[lo][hi] = Math.max(dp[lo][hi], coins);
                }
            }
        }
        
        return dp[1][n - 2];
    }
}