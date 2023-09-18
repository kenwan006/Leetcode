class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int l = strs.length;
        //dp[i][j][k] - given the capacity: j ones and k zeros, choose from strs[0..i] and put as many string into the bag as possible
        int[][][] dp = new int[l + 1][m + 1][n + 1]; 
        for (int i = 0; i <= l; i++) {
            if (i == 0) continue;
            int zeros = 0, ones = 0;
            for (char c : strs[i - 1].toCharArray()) {
                if (c == '0') zeros++;
                if (c == '1') ones++;
            }
            
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (j < zeros || k < ones) dp[i][j][k] = dp[i - 1][j][k];
                    else dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones] + 1);
                }
            }
        }
        return dp[l][m][n];
    }
}
//Time: O(m * n * l); Space: O(m * n * l)
