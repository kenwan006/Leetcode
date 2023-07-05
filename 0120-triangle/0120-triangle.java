class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] path = new int[n][n]; // path[i][j] - refers to the path sum from top to the triangle[i][j]
        for (int i = 0; i < n; i++) Arrays.fill(path[i], Integer.MAX_VALUE);
        path[0][0] = triangle.get(0).get(0);
        
        for (int i = 0; i < n - 1; i++) { //i stops at n - 2 not n - 1
            for (int j = 0; j <= i; j++) {
                //triangle[i][j] either go to triangle[i+1][j] or triangle[i+1][j+1]
                path[i + 1][j] = Math.min(path[i + 1][j], path[i][j] + triangle.get(i + 1).get(j));
                path[i + 1][j + 1] = Math.min(path[i + 1][j + 1], path[i][j] + triangle.get(i + 1).get(j + 1));
            }
        }
        
        //find the min at the (n-1)th row
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) res = Math.min(res, path[n-1][j]);
        return res;
    }
}
//Time: O(n ^ 2); Space: O(n ^ 2)
