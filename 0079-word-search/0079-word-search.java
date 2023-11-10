class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        TrieNode root = new TrieNode();
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'A';
            curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
        }
        curr.isEnd = true;
        
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, board, root)) return true;
            }
        }
        return false;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private boolean dfs(int i, int j, char[][] board, TrieNode curr) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return false;
        int idx = board[i][j] - 'A';
        if (curr.children[idx] == null) return false;
        curr = curr.children[idx];
        if (curr.isEnd) return true;
  
        visited[i][j] = true;
        for (int[] dir : dirs) {
            if (dfs(i + dir[0], j + dir[1], board, curr)) return true;
        }
        visited[i][j] = false;
        
        return false;
    }
    
    class TrieNode{
        TrieNode[] children = new TrieNode[58];
        boolean isEnd;
        public TrieNode(){};
    }
}