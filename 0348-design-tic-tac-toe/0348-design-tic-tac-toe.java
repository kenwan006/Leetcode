class TicTacToe {
    int[][] board;

    public TicTacToe(int n) {
        board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player; //occupy the position
        
        if (validCol(row, col, player) || validRow(row, col, player) || validDiagonal(row, col, player) || validAntiDiagonal(row, col, player)) return player;
        return 0;
    }
    
    private boolean validRow(int row, int col, int player) {
        for (int j = 0; j < board.length; j++) {
            if (board[row][j] != player) return false;
        }
        return true;
    }
    
    private boolean validCol(int row, int col, int player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != player) return false;
        }
        return true;
    }
    
    private boolean validDiagonal(int row, int col, int player) {
        if (row != col) return false;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != player) return false;
        }
        return true;
    }
    
    private boolean validAntiDiagonal(int row, int col, int player) {
        int n = board.length;
        if (row + col != n - 1) return false;
        for (int i = 0; i < n; i++) {
            if (board[i][n - 1 - i] != player) return false;
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */