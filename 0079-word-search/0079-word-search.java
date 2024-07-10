class Solution {
    private boolean[][] visited;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != word.charAt(0)) continue;
                if (dfs(board, i, j, word, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(idx) || visited[i][j]) return false;
        
        visited[i][j] = true;
        for (int[] dir : dirs) {
            if (dfs(board, i + dir[0], j + dir[1], word, idx + 1)) return true;
        }
        visited[i][j] = false;
        
        return false;
    }
}