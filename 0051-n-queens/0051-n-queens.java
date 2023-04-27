/** Backtraking **/
class Solution {
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    
    public List<List<String>> solveNQueens(int n) {
        //build the baord
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        
        backtrack(board, 0);
        return res;
    }
    
    //backtrack - i means the current row number
    public void backtrack(char[][] board, int i) {
        //reached the last row
        if (i == board.length) {
            res.add(new LinkedList(track));
            return;
        }
        
        //check each col at current row
        for (int j = 0; j < board.length; j++) {
            board[i][j] = 'Q';
            if (isValid(board, i, j)) {
                track.add(String.valueOf(board[i]));
                backtrack(board, i + 1); //move to next row
                track.removeLast();
            }
            board[i][j] = '.';
        }
    }
    
    //check if it's valid to put Q at (i, j)
    public boolean isValid(char[][] board, int row, int col) {
        //upper cell - same column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        //upper left - diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        //upper right - diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        
        return true;
    }
}