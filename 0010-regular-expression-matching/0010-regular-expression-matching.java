/** dp **
* dp[i][j] - means whether s[0..i) matches with the pattern p[0..j)
* 1, If p.charAt(j-1) == s.charAt(i -1) :  dp[i][j] = dp[i-1][j-1];
* 2, If p.charAt(j-1) == '.' : dp[i][j] = dp[i-1][j-1];
* 3, If p.charAt(j-1) == '*': 
  here are two sub conditions:
  1   if p.charAt(j-2) != s.charAt(i-1) && p.char(j -1) != '.'
         dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
  2   if p.charAt(j-2) == s.charAt(i-1) or p.charAt(j-1) == '.':
         dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
*/
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        //when p is empty
        for (int i = 1; i <= m; i++) dp[i][0] = false;
        //when s is empty
        for (int j = 2; j <= n; j++) { 
            dp[0][j] = p.charAt(j -1) == '*' && dp[0][j - 2]; //skip the "c*" in p
        }
        
        //dp
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j -1) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                if (p.charAt(j - 1) == '*') {
                   dp[i][j] = dp[i][j - 2] || ((s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);    
                }
            }
        }
        return dp[m][n];
    }
}
//Time: O(m * n); Space: O(m * n)