class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        int[] dp1 = new int[n]; //dp1[j] - count of 'x' for submatrices ending at grid[i][j]
        int[] dp2 = new int[n]; //dp2[j] - count of 'y' for submatrices ending at grid[i][j]
        
        for (int i = 0; i < m; i++) {
            int cnt_x = 0, cnt_y = 0;
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if (c == 'X') cnt_x++;
                else if (c == 'Y') cnt_y++;
                
                dp1[j] += cnt_x;
                dp2[j] += cnt_y;
                
                if (dp1[j] == dp2[j] && dp1[j] > 0) res++;
            }
        }
        
        return res;
    }
}