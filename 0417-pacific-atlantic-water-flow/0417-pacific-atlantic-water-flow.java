/** dfs **/
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n]; //pac[i][j] - means water at (i, j) can flow to pacific
        boolean[][] atl = new boolean[m][n];
        
        //flow from left boundary and right boundary
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pac, 0);
            dfs(heights, i, n - 1, atl, 0);
        }
        
        // flow from top boundary and bottom boundary
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pac, 0);
            dfs(heights, m - 1, j, atl, 0);
        }
        
        //find the cell that can flow to both pacific and atlantic
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pac[i][j] && atl[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }
    
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public void dfs(int[][] heights, int i, int j, boolean[][] reachable, int preHeight) {
        if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length) return;
        if (heights[i][j] < preHeight || reachable[i][j]) return; 
        
        reachable[i][j] = true;
        
        for (int[] dir : dirs) {
            dfs(heights, i + dir[0], j + dir[1], reachable, heights[i][j]);
        }
    }
}
//Time: O(m * n); Space: O(m * n)