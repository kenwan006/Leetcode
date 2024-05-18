class Solution {
    private final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        //check if we click the unrevealed mine
        int i = click[0], j = click[1];
        if (board[i][j] == 'M') {
            board[i][j] = 'X';
        } else {
            dfs(i, j, board);
        }
        return board;
    }
    
    private void dfs(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'E') return;
        
        int mines = count(i, j, board); //count the 'M' around the cell
        if (mines > 0) {
            board[i][j] = (char) ('0' + mines); 
        } else {//only the 'E' without any mines around it can spread out
            board[i][j] = 'B';
            for (int[] dir : dirs) {
                dfs(i + dir[0], j + dir[1], board);
            }
        }
    }
    
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