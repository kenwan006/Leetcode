class Solution {
    List<List<String>> res = new LinkedList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n]; //build a chess board
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrack(0, board);
        return res;
    }
    
    private void backtrack(int i, char[][] board) {
        if (i == board.length) {
            res.add(toList(board));
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (validate(i, j, board)) {
                board[i][j] = 'Q';
                backtrack(i + 1, board);
                board[i][j] = '.';
            }
        }
    }
    
    private List<String> toList(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            list.add(new String(board[i])); //convert each row of the board to a string
        }
        return list;
    }
    
    private boolean validate(int row, int col, char[][] board) {
        //check upper
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }
        //check upper left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        //check upper right
        for (int i = row - 1, j = col + 1; i >=0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
    
}