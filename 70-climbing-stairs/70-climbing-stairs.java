/** DP + memoization
* dp[i] = dp[i - 1] + dp[i - 2], to climb n stairs, either get to i - 2 stairs and then take 2 steps at once, or get to i - 1 staris and then take 1 step at once.
*/
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        //base case
        dp[0] = 1;
        dp[1] = 1;
        // bottom up dp
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}