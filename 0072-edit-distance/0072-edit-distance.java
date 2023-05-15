/** dp 
* dp[i][j] - means the min distance between s1[0..i) and s2[0..j)
* If s1.charAt(i) == s2.charAt(j), then dp[i][j] = dp[i-1][j-1]; Otherwise
* If insert the ending char for s2, dp[i][j] = dp[i][j-1] + 1;
* If replace the ending char at s1 with ending char at s2, dp[i][j] = dp[i-1][j-1] + 1;
* If delete the ending char at s1, dp[i][j] = dp[i-1][j] + 1;
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        //when s2 is emtpy, just keep inserting the chars from s1
        for (int i = 0; i <= m; i++) dp[i][0] = i;
        //when s1 is empty, just keep inserting the chars from s2
        for (int j = 0; j <= n; j++) dp[0][j] = j;
        
        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else {
                    int insert = dp[i][j - 1] + 1;
                    int replace = dp[i - 1][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    dp[i][j] = Math.min(insert, Math.min(replace, delete));
                }
            }
        }
        return dp[m][n];
    }
}
//Time: O(m * n); Space: O(m * n)