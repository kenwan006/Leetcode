class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] adj = {-1, 0, 1};
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int ctn = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        int ii = r + adj[i], jj = c + adj[j];
                        if (ii < 0 || ii >= m || jj < 0 || jj >= n || board[ii][jj] <= 0) continue;
                        ctn++;
                    }
                }
                if (board[r][c] == 0) board[r][c] = -ctn;
                else board[r][c] = ctn;
            }      
        }
        
        //
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int num = board[r][c];
                if (num == 3 || num == 4 || num == -3) board[r][c] = 1;
                else board[r][c] = 0;
            }
        }
        
    }
}
//Time: O(m * n); Space: O(1)

