/** DP **/
class Solution {
    public int numSquares(int n) {
        int[] nums = getSquares(n);
        int m = nums.length;
        
        int[] dp = new int[n + 1]; //dp[j] - least number of nums to choose to fill the volume j
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        
        for (int i = 0; i < m; i++) { // i - num to choose
            for (int j = nums[i]; j <= n; j++) { // j - bag volume
                dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
            }
        }
        return dp[n];
    }
    
    // return list of perfect squares <= n
    private int[] getSquares(int n) {
        int size = (int) Math.sqrt(n);
        int[] squares = new int[size];
        for (int i = 1; i <= size; i++) {
            squares[i - 1] = i * i;
        }
        return squares;
    }
}
//Time: O(n * sqrt(n)); Space: O(n)
