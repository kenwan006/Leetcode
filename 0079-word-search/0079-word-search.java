class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0, board, word)) return true;
            }
        }
        return false;
    }
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(int i, int j, int k, char[][] board, String word) {
        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j]  != word.charAt(k)) return false;
        
        char c = board[i][j];
        board[i][j] = '#'; //mark as visited
        for (int[] dir : dirs) {
            if (dfs(i + dir[0], j + dir[1], k + 1, board, word)) return true;
        }
        board[i][j] = c;
        return false;
    }
}