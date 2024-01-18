class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) dfs(i, j, -1, rooms);
            }
        }
    }
    
    int[][] dirs = {{0, 1},{1, 0},{-1, 0}, {0, -1}};
    
    private void dfs(int i, int j, int prev, int[][] rooms) {
        rooms[i][j] = prev + 1;
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || ii >= rooms.length || jj < 0 || jj >= rooms[0].length || rooms[ii][jj] == -1) continue;
            if (rooms[ii][jj] <= rooms[i][j] + 1) continue;
            dfs(i + dir[0], j + dir[1], rooms[i][j], rooms);
        }
    }
        
}