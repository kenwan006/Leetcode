/** BFS **/
class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        boolean[][][] visited = new boolean[m][n][k + 1];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int step = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == m - 1 && curr[1] == n - 1 && curr[2] <= k) return step;
                
                for (int[] dir : dirs) {
                    int row = curr[0] + dir[0], col = curr[1] + dir[1];
                    if (row < 0 || col < 0 || row >= m || col >= n) continue;
                    
                    int obs = grid[row][col] == 1? curr[2] + 1 : curr[2]; //check if the next cell is a obstacle
                    if (obs > k || visited[row][col][obs]) continue;
                    
                    queue.offer(new int[]{row, col, obs});
                    visited[row][col][obs] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
//Time: O(m * n * k); Space: O(m * n * k)
