class Solution {
    int[][] memo;
    
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n]; // memo[i][j] - length of longest increasing path starting from matrix[i][j]
        
        int longest = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (memo[i][j] != 0) continue; // already visited
                longest = Math.max(longest, dfs(matrix, i, j));
            }
        }
        return longest;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];
        
        int path = 1;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= matrix.length || jj < 0 || jj >= matrix[0].length || matrix[ii][jj] <= matrix[i][j]) continue;
            path = Math.max(path, 1 + dfs(matrix, ii, jj));
        }
        memo[i][j] = path;
        return path;
    }
}