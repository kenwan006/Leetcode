/** dfs 
** Start from the 'O' on the borders, do the dfs traversal and turn all the adjacent 'O' to 'V'
**  After dfs is done, turn all the remaining 'O's to 'X' because they are captured by 'X'
** Turn all the 'V' back to 'O' because they are not captured
**/
class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        //start from top and bottom borders
        for(int j = 0; j < n; j++) {
            if (board[0][j] == 'O') dfs(0, j, board);
            if (board[m - 1][j] == 'O') dfs(m - 1, j, board);
        }
        
        //start from left and right borders
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') dfs(i, 0, board);
            if (board[i][n - 1] == 'O') dfs(i, n - 1, board);
        }
        
        //turn the remaining 'O' to 'x' and turn 'V' back to 'O'
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == 'V') board[i][j] = 'O';
            }
        }
    }
    
    int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    
    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'X' || board[i][j] == 'V') return; // X - no need to check; V - already checked
        board[i][j] = 'V'; //mark the uncaptured 'O' as 'V'
        for (int[] dir : dirs) {
            dfs(i + dir[0], j + dir[1], board);
        }
    }
}