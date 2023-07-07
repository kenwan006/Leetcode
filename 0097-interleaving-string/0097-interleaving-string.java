class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), p = s3.length();
        if (m + n != p) return false;
        
        boolean[][] dp = new boolean[m + 1][n + 1]; //dp[i][j] - refers to substring s1[0..i) interleavse with subsring s2[0..j)
        dp[0][0] = true;
        
        //if s1 is empty s1[0..0)
        for (int j = 1; j <= n; j++) dp[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1) && dp[0][j - 1];
        //if s2 is empty  s2[0..0)
        for (int i = 1; i <= m; i++) dp[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1) && dp[i - 1][0];
        
        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                dp[i][j] = (c1 == c3 && dp[i - 1][j]) || (c2 == c3 && dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }
}
//Time: O(m * n); Space: O(m * n)