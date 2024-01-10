class TicTacToe {
    int[][] mat;
    int n;

    public TicTacToe(int n) {
        mat = new int[n][n]; 
        this.n = n;
    }
    
    public int move(int row, int col, int player) {
        mat[row][col] = player; //fill the cell
        if (checkRow(row, col, player) || checkCol(row, col, player) ||
            (row == col) && checkDiagonal(player) || 
            (row + col == n-1) && checkAntiDiagonal(player)) {
            return player;
        }
        return 0;
    }
    
    private boolean checkRow(int row, int col, int player) {
        for (int i = 0; i < n; i++) {
            if (mat[row][i] != player) return false;
        }
        return true;
    }
    
    private boolean checkCol(int row, int col, int player) {
        for (int i = 0; i < n; i++) {
            if (mat[i][col] != player) return false;
        }
        return true;
    }
    
    private boolean checkDiagonal(int player) {
        for (int i = 0; i < n; i++) {
            if (mat[i][i] != player) return false;
        }
        return true;
    }
    
    private boolean checkAntiDiagonal(int player) {
        for (int i = 0; i < n; i++) {
           if (mat[i][n - 1 - i] != player) return false;
        }
        return true;
    }
}

//Time: O(n); Space: O(n * n)

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */