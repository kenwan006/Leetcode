class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        // Initialize the matrix, for the non-zero cell set it to MAX_VALUE
        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0) queue.add(new int[]{i, j});
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }
        // update the cell
        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n) continue;
                if(mat[newRow][newCol] > mat[cell[0]][cell[1]] + 1) {
                    mat[newRow][newCol] = mat[cell[0]][cell[1]] + 1;
                    queue.add(new int[]{newRow, newCol}); // add to queue once cell is updated with smaller value
                }
            }
        }
        return mat;
    }
}