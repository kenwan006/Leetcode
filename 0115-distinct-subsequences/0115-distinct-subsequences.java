/** dp **/
class Solution {
    public int numDistinct(String s, String t) {
        int m = t.length(), n = s.length();
        if (m > n) return 0;
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) dp[i][0] = 0; //when s is empty, it has no subsequence except ""
        for (int j = 0; j <= n; j++) dp[0][j] = 1; //when t is empty, it's always a subsequence of t
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(j - 1) == t.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1]; //either take s.chatAt(j-1) or not
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}
//Time: O(m * n); Space: O(m * n)

