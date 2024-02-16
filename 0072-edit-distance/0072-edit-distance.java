class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1]; //dp[i][j] - convert wrod1[0..i) to word2[0..j)
        
        //word1 is empty - just inert
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        //word2 is empty - just delete
        for (int i = 0; i <= m; i++) dp[i][0] = i; 
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    int dist1 = dp[i][j - 1];
                    int dist2 = dp[i - 1][j];
                    int dist3 = dp[i - 1][j - 1];
                    dp[i][j] = Math.min(dist1, Math.min(dist2, dist3)) + 1;
                }
            }
        }
        return dp[m][n];
    }
}