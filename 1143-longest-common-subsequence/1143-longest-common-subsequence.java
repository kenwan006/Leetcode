/** dp **/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        
        //dp[i][j] - means the longest common subsequence of s1[0..i] and s2[0..j]
        int[][] dp = new int[m + 1][n + 1]; 
        for (int i = 0; i <= m; i++) dp[i][0] = 0;
        for (int j = 0; j <= n; j++) dp[0][j] = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) { // text1 and text2 are 1-indexed now
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) { 
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    } 
}
//Time: O(m * n); Space: O(m * n)