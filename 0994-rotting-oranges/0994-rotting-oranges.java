/** BFS **/
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        int fresh = 0; //count of fresh orange
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }
        
        int time = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty() && fresh != 0) {
            int size = queue.size();
            time++;
            for (int k = 0; k < size; k++) {
                int[] cell = queue.poll(); //poll a rotten orange
                for (int[] dir : dirs) {
                    int i = cell[0] + dir[0], j = cell[1] + dir[1];
                    if (i < 0 || j < 0 || i >= m || j >= n) continue;
                    if (grid[i][j] == 1) {
                        grid[i][j] = 2; //fresh orange rotts
                        fresh--;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }
        
        return fresh == 0? time : -1;
    }
}
//Time: O(m * n); Space: O(m * n)