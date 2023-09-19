class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1; //choose nothing if target is 0
        
        for (int i = 0; i <= target; i++) { //i - volume
            for (int j = 0; j < n; j++) { //j - num
                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
//Time: O(m * n); Space: O(m)