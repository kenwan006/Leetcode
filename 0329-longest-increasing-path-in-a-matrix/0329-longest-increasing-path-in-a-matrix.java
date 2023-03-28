/** DFS + memoization
* moem[i][j] - the longest increasing path starting from position (i, j);
* For cell at (i, j), check all its neighbors to see which one bring about the longest increasing path
*/
class Solution {
    private int[][] memo;
    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        int res = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] != 0) continue; // skip the already checked cell
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }
    
    //dfs
    public int dfs (int[][]matrix, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        if (memo[i][j] != 0) return memo[i][j];
        
        int ans = 1;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || matrix[ii][jj] <=  matrix[i][j]) continue;
            ans= Math.max(ans, 1 + dfs(matrix, ii, jj));
        }
        memo[i][j] = ans; //update the memo
        return ans;
    }
}
//Time: O(m * n); Space: O(m * n)