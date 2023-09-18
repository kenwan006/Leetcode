/** DP 
** Split the stones into two group
** Try to minimize the weight difference of two grups
** Given a bag with capacity of sum / 2, fill up the bag with as many stones as possible
**/
class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length, sum = 0;
        for (int stone : stones) sum += stone;
        
        //dp[i][j] - given the bag capacity j, the max weight it can carry using stones from [0..i] 
        int m = sum / 2;
        int[][] dp = new int[n + 1][m + 1]; 
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < stones[i - 1]) dp[i][j] = dp[i - 1][j]; //skip ith stone
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]); //pick ith stone
            }
        }
        
        // the first group has weight dp[n][sum] and second group has weight sum
        return sum - dp[n][m] * 2;
    }
}
//Time: O(m * n); Space: O(m * n)
