class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; //dp[i] - length of LIS ending at nums[i]
        int[] count = new int[n]; // count[i] - count of longest LIS ending at nums[i]
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j]; //just append nums[i] to nums[j]
                    } else if (dp[i] == dp[j] + 1) {
                        count[i] += count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxLen) {
                res += count[i];
            }
        }
        return res;
    }
}
//Time: O(n * n); Space: O(n)
