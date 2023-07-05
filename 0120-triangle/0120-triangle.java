class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] path = new int[n][n]; // path[i][j] - refers to the path sum from top to the triangle[i][j]
        for (int i = 0; i < n; i++) Arrays.fill(path[i], Integer.MAX_VALUE);
        path[0][0] = triangle.get(0).get(0);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) path[i][j] = Math.min(path[i][j], path[i - 1][j - 1]);
                if (j < n) path[i][j] = Math.min(path[i][j], path[i - 1][j]);
                path[i][j] += triangle.get(i).get(j);
            }
        }
        
        //find the min at the (n-1)th row
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) res = Math.min(res, path[n-1][j]);
        return res;
    }
}
//Time: O(n ^ 2); Space: O(n ^ 2)
