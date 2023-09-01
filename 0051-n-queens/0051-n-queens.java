class Solution {
    List<List<String>> res = new LinkedList<>();
    LinkedList<String> track = new LinkedList<>();
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new  char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        backTracking(board, 0);
        return res;
    }
    
    private void backTracking(char[][] board, int i) {
        if (i == board.length) {
            res.add(new LinkedList(track));
            return;
        }
        
        for (int j = 0; j < board.length; j++) {
            if (!valid(board, i, j)) continue;
            board[i][j] = 'Q';
            track.add(String.valueOf(board[i]));
            backTracking(board, i + 1);
            track.removeLast();
            board[i][j] = '.';
        }
    }
    
    private boolean valid(char[][] board, int i , int j) {
        //check top left diagonal
        for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') return false;
        }
        
        //check top
        for (int r = i - 1; r >= 0; r--) {
            if (board[r][j] == 'Q') return false;
        }
        
        //check top right diagonal
        for (int r = i - 1, c = j + 1; r >= 0 && c < board.length; r--, c++) {
            if (board[r][c] == 'Q') return false;
        }
        return true;
    }
}