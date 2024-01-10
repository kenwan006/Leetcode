class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int n;
    
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n]; //rows[i] - means the sum of this ith row
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int toAdd = player == 1? 1 : -1;  //if it's player1, add 1; if it's player2, minus 1
        int target = player == 1? n : -n; // if it's player1, its target is n; it's -n for the other
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) diagonal += toAdd;
        if (row + col == n - 1) antiDiagonal += toAdd;
        
        if (rows[row] == target || cols[col] == target || diagonal == target || antiDiagonal == target) return player;
        return 0;
    }
}

//Time: O(1);Space: O(n)


/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */