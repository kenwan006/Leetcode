class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //keep updating and store the min sum of path from top -> [i, j] at triangle[i][j]
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int smallest = Integer.MAX_VALUE;
                if (j > 0) smallest = Math.min(smallest, triangle.get(i - 1).get(j - 1));
                if (j < i) smallest = Math.min(smallest, triangle.get(i - 1).get(j));
                int path = smallest + triangle.get(i).get(j); //at ith row, update the min path for each col
                triangle.get(i).set(j, path);                  
            }
        }
        
        //find the min at the bottom row
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) res = Math.min(res, triangle.get(n - 1).get(j));
        return res;
    }
}
//Time: O(n ^ 2); Space: O(1)

