class Solution {
    List<List<String>> res = new LinkedList<>();
    char[][] board;
    public List<List<String>> solveNQueens(int n) {
        board = new char[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(board[i], '.');
        backtrack(0);
        return res;
    }
    
    private void backtrack(int i) {
        if (i == board.length) {
            List<String> list = convert(board);
            res.add(list);
            return;
        }
           
        for (int j = 0; j < board.length; j++) {
            if (!isValid(i, j)) continue; //skip if filling cell[i][j] with 'Q' generate a invalid placement
            board[i][j] = 'Q';
            backtrack(i + 1);
            board[i][j] = '.';
        }
    }
    
    private boolean isValid(int i, int j) {
        int n = board.length;

        //check upper
        for (int r = i - 1; r >= 0; r--) {
            if (board[r][j] == 'Q') return false;
        }
                
        //chceck upper left
        for (int r = i - 1, c = j - 1; r >= 0 && c >= 0; r--, c--) {
            if (board[r][c] == 'Q') return false;
        }
                
        //check upper right
        for (int r = i - 1, c = j + 1; r >= 0 && c < n; r--, c++) {
            if (board[r][c] == 'Q') return false;
        }        
        return true;
    }
    
    private List<String> convert(char[][] board) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) list.add(new String(board[i]));
        return list;
    }
}