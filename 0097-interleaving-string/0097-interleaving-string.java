class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), p = s3.length();
        if (m + n != p) return false;
        
        boolean[][] dp = new boolean[m + 1][n + 1]; //dp[i][j] - s1[0..i) and s2[0..j) form s3[0..i + j - 1)
        dp[0][0] = true;
        
        //s2 is empty
        for (int i = 1; i <= m; i++) {
            dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1)? dp[i - 1][0] : false;
        }
        
        //s1 is empty
        for (int j = 1; j <= n; j++) {
            dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1)? dp[0][j - 1] : false;
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i - 1][j]) || (s2.charAt(j - 1) == s3.charAt(i + j - 1) && dp[i][j - 1]);
            }
        }
        
        return dp[m][n];
    }
}