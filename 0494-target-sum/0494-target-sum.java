class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //sumA - sum of positive nums, sumB - sum of negative nums
        // sumA - sumB = target, sumA + sumB = sum ==> sumA = (target + sum) / 2
        //fill the bag of volume = (target+sum)/2 selecting from given nums
        
        int sum = target;
        for (int num : nums) sum += num;
        if (sum < 0 || sum % 2 != 0) return 0; //check if sum >= 0 first
        sum /= 2;
        
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        
        for (int j = 0; j <= sum; j++) dp[0][j] = 0;
        dp[0][0] = 1;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                int curr = nums[i - 1];
                if (curr > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] + dp[i - 1][j - curr];
            }
        }
        return dp[n][sum];
    }
}