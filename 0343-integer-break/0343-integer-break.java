class Solution {
    public int integerBreak(int n) {
        // n >= 2, k >= 2
        int[] dp = new int[n + 1]; //dp[i] - break integer i and get the max product 
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                // break integer i into two part j and i - j
                // either just take j or break j to get dp[j]
                dp[i] = Math.max(dp[i], Math.max(dp[j] * (i - j), j * (i - j)));  
            }
        }
        return dp[n];
    }
}
//Time: O(n * n); Space: O(n)

