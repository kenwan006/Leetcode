class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n];//dp[i] - menas the min cost needed if increase nums[i] to k and make nums[0..i] beautiful
        dp[0] = Math.max(0, k - nums[0]);
        dp[1] = Math.max(0, k - nums[1]);
        dp[2] = Math.max(0, k - nums[2]);
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(0, k - nums[i]);
            dp[i] += Math.min(dp[i - 1], Math.min(dp[i - 2], dp[i - 3]));
        }
        return Math.min(dp[n - 1], Math.min(dp[n - 2], dp[n - 3]));
    }
}
//Time: O(n); Space: O(n)
