/** DP
* Define an array dp, dp[i] represents the largest sum of the subarray ending with item num[i];
* If dp[i - 1] < 0, dp[i]  = nums[i]; otherwise dp[i] = dp[i-1] + nums[i];
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0]; //do not use MIN_VALUE because for loop starts at i = 1 not 0
        
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}