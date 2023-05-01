/** dfs *
* 'O' on the boarder will not be flipped, and any of its adjacent 'O' will not be flipped either. Mark them as '*' and reset to 'O' in the end.
*/
class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        
        //start from left and right boarders
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(board, i, 0);
            if (board[i][n - 1] == 'O') dfs(board, i, n - 1);
        }
        
        //start from top and bottom boarders
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(board, 0, j);
            if (board[m - 1][j] == 'O') dfs(board, m - 1, j);
        }
        
        //set remaining 'O' to 'X', and reset '*' to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void dfs(char[][] board, int i , int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
        
        if ( board[i][j] == 'X' || board[i][j] == '*') return;
        
        board[i][j] = '*'; //mark
        for (int[] dir : dirs) {
            dfs(board, i + dir[0], j + dir[1]);
        }
    }
}

//Time: O(m * n); Space: O(1)