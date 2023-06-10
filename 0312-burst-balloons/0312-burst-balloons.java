/** dp 
* dp[l][r] - means the max collection for nums[l..r];
* Iterate the size of the window [lo..hi] from 1 to nums.length
* Let i be the **last** burst balloon in the nums[lo..hi]  gain = nums[lo-1] * nums[i] * nums[hi+1], remaining = dp[lo][i-1] + dp[i+1][hi]
* Check each i and find the max one, then dp[lo][hi] = max{gain + remaining}
* Note: extend the nums to left and right by 1 in order to handle the boundary issue
*/
class Solution {
    public int maxCoins(int[] nums) {
        //extend to left and right by 1, and copy nums to new nums
        int n = nums.length + 2; 
        int[] newNums = new int[n];
        for (int i = 0; i < nums.length; i++) newNums[i + 1] = nums[i];
        newNums[0] = 1;
        newNums[n - 1] = 1;
        
        int[][] dp = new int[n][n]; 
        
        for (int len = 1; len <= n - 2; len++) {
            for (int lo = 1; lo <= n - len - 1; lo++) {
                int hi = lo + len - 1;
                for (int i = lo; i <= hi; i++) {
                    int remaining = dp[lo][i - 1] + dp[i + 1][hi];
                    //i is the last balloon to burst
                    int gain = newNums[lo - 1] * newNums[i] * newNums[hi + 1];
                    dp[lo][hi] = Math.max(dp[lo][hi], gain + remaining);
                }
            }
        }
        return dp[1][n -2];
    }
}
//Time: O(n ^ 3); Space: O(n ^ 2)