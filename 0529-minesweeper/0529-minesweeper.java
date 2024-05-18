class Solution {
    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int i = click[0], j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(click);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] curr = queue.poll();
                int row = curr[0], col = curr[1];
                int mines = count(row, col, board);
                if (mines > 0) {
                    board[row][col] = (char)('0' + mines);
                } else {
                    board[row][col] = 'B';
                    for (int[] dir : dirs) {
                        int r = row + dir[0], c = col + dir[1];
                        if (r < 0 || c < 0 || r >= m || c >= n || board[r][c] != 'E') continue;
                        board[r][c] = 'B'; //mark as visited to avoid duplicate add to queue
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }
        return board;
    }
    
    //count the mines around a 'E'
    private int count(int i, int j, char[][] board) {
        int count = 0;
        for (int[] dir : dirs) {
            int row = i + dir[0], col = j + dir[1];
            if (row < 0 || col < 0 || row >= board.length || col >= board[0].length) continue;
            if (board[row][col] == 'M') count++;
        }
        return count;
    }
}