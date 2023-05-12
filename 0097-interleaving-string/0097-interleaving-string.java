/** dp **/
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) return false;
        
        //consider s1, s2, s3 are all 1-indexed
        //dp[i][j] means s1[0..i-1] and s2[0..j-1] can form s3[0..i+j-1] by interleaving
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        //if s1 is empty
        for (int j = 1; j <= n; j++) dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        
        //if s2 is empty
        for (int i = 1; i <= m; i++) dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        
        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                dp[i][j] = (dp[i - 1][j] && c1 == c3) || (dp[i][j - 1] && c2 == c3);
            }
        }
        return dp[m][n];
    }
}
//Time: O(m * n); Space: O(m * n)