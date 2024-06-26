/** dp
** eg, from any top left cell c1 to ck at grid[i][j],  the total score is ck - ck-1 + ck-1 - ck-2...+c2 - c1 = ck - c1 
** In order to find a max total score ending at [i, j], we need to find the smallest c1
** c1 could be any cell at the left right of ck
** dp[i][j] - means the smallest num in the area from [0, 0] to [i, j]
** then this c1 = Math.min(dp[i - 1][j], dp[i][j - 1]);
**/
class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] dp = new int[m][n]; // dp[i][j] - min num in the grid from [0, 0] to [i, j]
        dp[0][0] = grid.get(0).get(0);
        
        int res = Integer.MIN_VALUE;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int prev1 = i > 0? dp[i - 1][j] : 1000000; //upper one
                int prev2 = j > 0? dp[i][j - 1] : 1000000; //left one
                int curr = grid.get(i).get(j);
                
                res = Math.max(res, curr - Math.min(prev1, prev2));
                
                dp[i][j] = Math.min(curr, Math.min(prev1, prev2));
                
            }
        }
        return res;
    }
}