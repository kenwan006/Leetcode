class Solution {
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(dfs(board, i, j, word, 0)) return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, int i, int j, String word, int step) {
        if (step == word.length()) return true;
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) return false;
        
        if (board[i][j] != word.charAt(step)) return false;
     
        visited[i][j] = true;
        for (int[] dir : dirs) {
            if (dfs(board, i + dir[0], j + dir[1], word, step + 1)) return true;
        }
        visited[i][j] = false;
        
        return false;
    }
}