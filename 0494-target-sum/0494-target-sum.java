class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = target;
        for (int num : nums) sum += num;
        if (sum < 0 || sum % 2 != 0) return 0;
        sum /= 2;
        
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j < nums[i - 1]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[n][sum];
    }
}