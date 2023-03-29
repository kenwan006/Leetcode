/** DP
* dp[i] - least number of perfect square numbers that sums up to i
* dp[i] = dp[j] + dp[i - j], iterate j from i- 1 to 1 and find the min value
*/
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i == (int)Math.sqrt(i) * (int)Math.sqrt(i)) { //check if the number itself is squared
                dp[i] = 1;
                continue;
            }
            
            int min = Integer.MAX_VALUE;
            for (int j = i - 1; j > 0; j--) {
                min = Math.min(min, dp[j] + dp[i - j]);
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
//Time: O (n ^ 2); Space: O(n)