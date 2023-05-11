/** dp 
* sum1 means sum of all nums added with '+', sum2 means sum of all nums added with '-'
* sum1 - sum2 = target --> 2*sum1 = target + sum1 + sum2 = target + sum   -->  sum1 = (target + sum) / 2
* fill up the (target+sum)/2 using the nums
**/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = target;
        for (int num : nums) sum += num;
        if (sum % 2 != 0 || sum < 0) return 0;
        
        //find ways to fill up the sum with given nums
        int m = nums.length, n = sum / 2;
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) dp[0][j] = 0; //can comment out this line
        dp[0][0] = 1;
       
        
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //start from j=0 not j=1
                //num = 0 can be used to fill the volume j = 0
                
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[m][n];
    }
}
//Time: O(m * n); Space: O(m * n)