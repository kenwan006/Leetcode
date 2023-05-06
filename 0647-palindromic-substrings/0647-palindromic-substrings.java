/** dp **/
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                dp[i][j] = j - i <= 2?  s.charAt(i) == s.charAt(j) : s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                if (dp[i][j]) count++;
            }
        }
        return count;
    }
}
//Time: O(n * n); Space: O(n * n)