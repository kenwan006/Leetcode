class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //use obstacleGrid[i][j] to represent number of pathes from start to [i][j].
        //No need to create a new dp[][]
        
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        
        //check the start point - if it's an obstacle, set it to 0
        obstacleGrid[0][0] = obstacleGrid[0][0] == 1? 0 : 1; 
        
        //check first column
        for (int i = 1; i < m; i++) obstacleGrid[i][0] = obstacleGrid[i][0] == 1? 0 : obstacleGrid[i - 1][0];
        
        //check first row
        for (int j = 1; j < n; j++) obstacleGrid[0][j] = obstacleGrid[0][j] == 1? 0 : obstacleGrid[0][j - 1];
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) obstacleGrid[i][j] = 0;
                else obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            } 
        }
        return obstacleGrid[m - 1][n - 1];
    }
}
//Time: O(m * n); Space: O(1)