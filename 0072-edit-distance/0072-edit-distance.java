class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1]; //dp[i][j] - refers to distance from substring of word1[0..i) to word2[0..j)
        
        //word1.substring[0..0) - empty
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        //word2.substring[0, 0) - empty
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        
        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                /** insert - dp[i][j-1]; delete - dp[i-1][j]; replace - dp[i-1][j-1] **/
                else dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1])) + 1;
            }
        }
        return dp[m][n];
    }
}
//Time: O(m * n); Space: O(m * n)
