class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, res = 1;
        int[] dp = new int[n]; //dp[i] refers to the LIS ending with nums[i]
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] <= nums[j]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//Time: O(n ^ 2); Space: O(n)