class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n]; //dp[i] - length of LIS ending with nums[i]
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; i++) {
            //find all the nums[j] that is smaller than nums[i]
            int j = i - 1;
            while (j >= 0){
                if (nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
                j--;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}