class Solution {
    int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int largestIsland(int[][] grid) {
        //Calculate area for each island without marking
        int n = grid.length;
        int maxArea = 0;
        Map<Integer, Integer> map = new HashMap<>(); //map indetifier -> its area
        int id = 2; //starting from 2 as 0 and 1 are existing in the grid
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int count = dfs(i, j, id, grid);
                    maxArea = Math.max(maxArea, count); //init maxArea without changing water to island
                    map.put(id++, count); 
                }
            }
        }
        
        //find the larget island if changing one water to island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) continue;
                int area = 1; //turn water to island
                Set<Integer> connected = new HashSet<>(); //check if the changed water connect to any existing island group
                
                for (int[] dir : dirs) {
                    int ii = i + dir[0], jj = j + dir[1];
                    if (ii < 0 || jj < 0 || ii >= grid.length || jj >= grid[0].length || grid[ii][jj] == 0) continue;
                    int islandId = grid[ii][jj];
                    connected.add(islandId);
                }
                for (int islandId : connected) area += map.get(islandId);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
    
    //starting from cell[i, j], mark all connected islands as id
    private int dfs(int i, int j, int id, int[][] grid) {
        int count = 1;
        grid[i][j] = id; //mark visited island as current id 
        for (int[] dir : dirs) {
            int ii = i + dir[0], jj = j + dir[1];
            if (ii < 0 || jj < 0 || ii >= grid.length || jj >= grid[0].length) continue;
            if (grid[ii][jj] == 0 || grid[ii][jj] == id) continue;
            count += dfs(ii, jj, id, grid);
        }
        return count;
    }
}
//Time: O(n * n); Space: O(n * n)
