/** DP
* dp[i] - least number of perfect square numbers that sums up to i
* dp[i] = dp[i - j*j] + dp[j*j] = dp[i - j*j] + 1; iterate j from 1 to sqrt(i)
*/
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
//Time: O (n * sqrt(n)); Space: O(n)