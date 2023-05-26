/** DP *
* dp[i] - means the minimum flips for string s[0...i]
* If s[i] = '1', no neede to flip, dp[i] = dp[i-1]
* If s[i] = '0', either flip it to 1, then dp[i] = dp[i-1] + 1; Or not flip s[i], but flip all '1's in s[0..i-1], dp = number of existing '1'
*/
class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = 0; 
        int num = s.charAt(0) == '1'? 1 : 0; // number of '1'
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '1') {
                dp[i] = dp[i - 1];
                num++;
            } else {
                dp[i] = Math.min(dp[i - 1] + 1, num);
            } 
        }
        return dp[n - 1];
    }
}
//Time: O(n); Space: O(n)