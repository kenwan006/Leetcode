/** dfs + heap **/
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int depth = 0;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        heap.offer(new int[]{0, 0});
        
        boolean[][] visited = new boolean[n][n];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            depth = Math.max(depth, grid[curr[0]][curr[1]]);
            if (curr[0] == n -1 && curr[1] == n - 1) return depth;
            for (int[] dir : dirs) {
                int ii = curr[0] + dir[0], jj = curr[1] + dir[1];
                if (ii < 0 || jj < 0 || ii >= n || jj >= n || visited[ii][jj]) continue;
                heap.offer(new int[]{ii, jj});
                visited[ii][jj] = true;
            }
        }
        return -1;
    }
}
//Time: O(n * n * log(n)); Space: O(n * n)