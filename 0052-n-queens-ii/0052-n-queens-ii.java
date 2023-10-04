class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrack(0, board);
        return count;
    }
    
    private void backtrack(int i, char[][] board) {
        if (i == board.length) {
            count++;
            return;
        }
        
        for (int j = 0; j < board[0].length; j++) {
            if (validate(i, j, board)) {
                board[i][j] = 'Q';
                backtrack(i + 1, board);
                board[i][j] = '.';
            }
        }
    }
    
    private boolean validate(int row, int col, char[][] board) {
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}