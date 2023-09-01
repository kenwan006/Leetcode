class Solution {
    public void solveSudoku(char[][] board) {
        backTracking(board);
    }
    
    private boolean backTracking(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char c = '1'; c <= '9'; c++) {
                    if (valid(board, i, j, c)) {
                        board[i][j] = c;
                        if (backTracking(board)) return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
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