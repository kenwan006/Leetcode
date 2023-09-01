class Solution {
    public void solveSudoku(char[][] board) {
        backTracking(board, 0, 0);
    }
    
    private boolean backTracking(char[][] board, int i, int j) {
        if (j == 9) return backTracking(board, i + 1, 0);
        if (i == 9) return true; //it means all rows have been checked
        
        if (board[i][j] != '.') return backTracking(board, i, j + 1);
        
        for (char c = '1'; c <= '9'; c++) {
            if (valid(board, i, j, c)) {
                board[i][j] = c;
                if (backTracking(board, i, j + 1)) return true;
                board[i][j] = '.';
            }
        }
        return false;
    }
    
    private boolean valid(char[][] board, int i, int j, char c) {
        for (int d = 0; d < 9; d++) {
            if (board[i][d] == c) return false;
            if (board[d][j] == c) return false;
            if (board[i / 3 * 3 + d / 3][j / 3 * 3 + d % 3] == c) return false;
        }
        return true;
    }
}