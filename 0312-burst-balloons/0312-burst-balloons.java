class Solution {
    int[][] dp;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        return burst(0, n - 1, nums);
    }
    
    private int burst(int lo, int hi, int[] nums) {
        if (lo > hi) return 0;
        if (dp[lo][hi] != 0) return dp[lo][hi]; //already checked
        
        int coins = 0;
        for (int i = lo; i <= hi; i++) { //i - the last balloon to burst
            int gain = nums[i];
            if (lo - 1 >= 0) gain *= nums[lo - 1];
            if (hi + 1 < nums.length) gain *= nums[hi + 1];
            
            gain += burst(lo, i - 1, nums) + burst(i + 1, hi, nums);
            
            coins = Math.max(coins, gain);
        }
        
        dp[lo][hi] = coins;
        return coins;
    }
}