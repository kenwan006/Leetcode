class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) return true; 
        
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (visited[i][j] || board[i][j] != word.charAt(idx)) return false;
        
        visited[i][j] = true;
        
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (dfs(board, ii, jj, word, idx + 1)) return true;
        }
        
        visited[i][j] = false;
        
        return false;
    }
}