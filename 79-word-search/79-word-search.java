/*  Backtracking + DFS
- Check each point in the board until find the starting point
- Start to find the word
- Check each direction of the current cell, increment the start index by 1, and search from this new start

**/

class Solution {
    private int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean find(char[][] board, String word, int row, int col, int start) {
        //base case
        if (start == word.length()) return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
        if (visited[row][col] || board[row][col] != word.charAt(start)) return false;
        
        //backtracking
        visited[row][col] = true;     
        for (int[] dir : dirs) {
            if (find(board, word, row + dir[0], col + dir[1], start + 1)) return true;
        }
        //if it can't go deeper when all directions return false, set it back to false for futher use
        visited[row][col] = false; 
        
        return false;
    }
}