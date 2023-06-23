class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word)) return true;
            }
        }
        return false;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(char[][] board, int i, int j, int k, String word) {
        if (k == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        
        char c = board[i][j];
        if (c== '#'|| word.charAt(k) != c) return false;
        
        board[i][j] = '#'; //mark as visited;
        for (int[] dir : dirs) {
            if (dfs(board, i + dir[0], j + dir[1], k + 1, word)) return true;
        }
        board[i][j] = c; // remark as unvisited
        
        return false;
    }
}
//Time: O(m * n * 4 ^ L); Space: O()