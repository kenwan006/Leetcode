/** DFS **/
class Solution {
    public int pathSum(int[] nums) {
        int[][] paths = new int[5][9];
        for (int i = 0; i < 5; i++) Arrays.fill(paths[i], -1);
        for (int num : nums) {
            int d = num / 100;
            int p = num / 10 % 10;
            paths[d][p] = num % 10;
        }
        
        return dfs(1, 1, 0, paths);
    }
    
    private int dfs(int d, int p, int sum, int[][] paths) {
        if (d >=5 || p >= 9 || paths[d][p] == -1) return 0; //null node
        
        sum += paths[d][p];
        int lsum = dfs(d + 1, p * 2 - 1, sum, paths);
        int rsum = dfs(d + 1, p * 2, sum, paths);
        
        if (lsum == 0 && rsum == 0) return sum; //leaf
        return lsum + rsum;
    }
}