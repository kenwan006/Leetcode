class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int target = player == 1? n : -n;
        int toAdd = player == 1? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) diagonal += toAdd;
        if (row + col == n - 1) antiDiagonal += toAdd;
        
        if (rows[row] == target || cols[col] == target || diagonal == target || antiDiagonal == target) return player;
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */