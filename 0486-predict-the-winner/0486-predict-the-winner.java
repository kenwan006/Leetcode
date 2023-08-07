class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        //dp[i][j] - max point 1st player (not necessarily palyer1) can gain more than the other player given the array nums[i..j]
        int[][] dp = new int[n][n]; 
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        
        //bottom-up dp
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                // first player takes nums[i], then the other choose from [i-1..j] and max point he can achieve mroe than 1st player is dp[i-1][j]
                // first player takes nums[j], then the other choose from [i..j-1] amd max point he can achieve mroe than 1st player is dp[i][j-1]
                int j = i + d;
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] >= 0;
    }
}
//Time: O(n * n); Space: O(n * n)
