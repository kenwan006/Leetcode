class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n]; //dp[i][j] - refers to square area with all 1s ending with right bottom at matrix[i][j]
        int maxArea = 0;
        
        //base case
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                maxArea = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                maxArea = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        
        //dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') continue;
                //find the min among left square, upper sqaure and upper-left square
                int L = (int) Math.sqrt(Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])));
                dp[i][j] = (L + 1) * (L + 1);
                maxArea = Math.max(maxArea, dp[i][j]);
            }
        }
        return maxArea;
    }
}

//Time: O(m * n); Space: O(m * n)
