/** DP
* dp[i][j] - means if we can choose item from nums[0]..nums[i] to fill up the bag of volume = j
* To fill up the volume j evenly using item nums[0]..nums[i],
we either pick nums[i], then we have to use nums[0]..nums[i-1] to fill up j - num[i] evenly;
or we don't pick nums[i], then we have to use nums[0]..num[i] to fill up j evenly
* dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]]
*/

/*
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        sum = sum / 2; // use nums to fill up the bag of volume = sum
        
        int m = nums.length;
        boolean[][] dp = new boolean[m][sum + 1];
        //Base case
        if (nums[0] == sum) dp[0][nums[0]] = true; // first row
        for (int i = 0; i < m; i++) dp[i][0] = true; // first column
     
        for (int i = 1; i < m; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i -1][j];
                } else {
                    dp[i][j] = dp[i -1][j] || dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[m - 1][sum];
    }
}
*/

// The above approach can be optimitized
/* For each row we are doing the same thing, which is update the value in previous row and add them to the current row,
* so the 2D array can be degraded to a 1D array
* Note: start j from right to left!!
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) sum += num;
        if(sum % 2 != 0) return false; // choose n items from nums and the sum is volume/2.
        sum /= 2;
        
        boolean[] dp = new boolean[sum + 1]; // 0, 1, 2.., volume
        dp[0] = true;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) { // if start from j =0, there will be overwrite for dp[j]
                if(j >= nums[i]) dp[j] = dp[j] || dp[j - nums[i]];
                //dp[j] stays if j < nums[i]
            }
        }
        return dp[sum];
    }
}
