class Solution {
    int N;
    int ctn = 0;
    char[][] board;
    public int totalNQueens(int n) {
        N = n;
        board = new char[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(board[i], '.');
        backtrack(board, 0);
        return ctn;
    }
    
    private void backtrack(char[][] board, int i) {
        if (i == N) ctn++;
        
        for (int j = 0; j < N; j++) {
            if (!validate(i, j)) continue;
            board[i][j] = '#';
            backtrack(board, i + 1);
            board[i][j] = '.';
        }  
    }
    
    private boolean validate(int row , int col) {
        //check the left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == '#') return false;
        }
        //check the top
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == '#') return false;
        }
        //check the right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == '#') return false;
        }
        return true;
    }
}