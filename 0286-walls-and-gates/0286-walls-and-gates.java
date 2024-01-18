class Solution {
    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        int m = rooms.length, n = rooms[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) queue.offer(new int[]{i, j});
            }
        }
        
        int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        int dist = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] dir : dirs) {
                    int r = curr[0] + dir[0];
                    int c = curr[1] + dir[1];
                    if (r < 0 || r >= m || c < 0 || c >= n || rooms[r][c] <  Integer.MAX_VALUE) continue;
                    rooms[r][c] = dist;
                    queue.offer(new int[]{r, c});
                }
            }
            dist++;
        }
    }
}