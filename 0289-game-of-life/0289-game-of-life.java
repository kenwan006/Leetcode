class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] adj = {0, -1, 1};
        
        //For each cell, count the live neighbors including *itself*
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
                if (board[r][c] == 1) board[r][c] = ctn;  //For live cell, mark its live neighbors as ctn
                if (board[r][c] == 0) board[r][c] = -ctn; //For dead cell, mark its live neighbors as -ctn
            }      
        }
        
        //update the board
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

