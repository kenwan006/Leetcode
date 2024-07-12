class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        
        boolean[][] pac_reachable = new boolean[m][n];
        boolean[][] atl_reachable = new boolean[m][n];
        
        //let's flow from pacific back to island
        for (int j = 0; j < n; j++) dfs(heights, pac_reachable, 0, j, 0);
        for (int i = 0; i < m; i++) dfs(heights, pac_reachable, i, 0, 0);
        
        //let's flow from atlantic back to island
        for (int j = 0; j < n; j++) dfs(heights, atl_reachable, m - 1, j, 0);
        for (int i = 0; i < m; i++) dfs(heights, atl_reachable, i, n - 1, 0);
        
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac_reachable[i][j] && atl_reachable[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        
        return res;
    }
    
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private void dfs(int[][] heights, boolean[][] reachable, int i, int j, int pre_height) {
        if (i < 0 || i >= heights.length || j < 0 || j >= heights[0].length || heights[i][j] < pre_height || reachable[i][j]) return;
        
        reachable[i][j] = true;
        for (int[] dir : dirs) {
            dfs(heights, reachable, i + dir[0], j + dir[1], heights[i][j]);
        }
    }
}