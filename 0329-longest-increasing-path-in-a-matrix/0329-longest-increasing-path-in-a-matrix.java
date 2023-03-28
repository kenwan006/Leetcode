/** DFS + memoization
* moem[i][j] - the longest increasing path starting from position (i, j);
* For cell at (i, j), check all its neighbors to see which one bring about the longest increasing path
*/
class Solution {
    int[][] memo;
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) Arrays.fill(memo[i], 1); //fill all cells with 1
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] > 1) continue; // skip the already checked cell
                res = Math.max(res, dfs(matrix, i, j));
            }
        }
        return res;
    }
    
    //dfs
    public int dfs (int[][]matrix, int i, int j) {
        int m = matrix.length, n = matrix[0].length;
        if (memo[i][j] > 1) return memo[i][j];
        
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= m || jj < 0 || jj >= n || matrix[ii][jj] <=  matrix[i][j]) continue;
            memo[i][j] = Math.max(memo[i][j], 1 + dfs(matrix, ii, jj));
        }
        return memo[i][j];  
    }
}
//Time: O(m * n); Space: O(m * n)