class Solution {
    public boolean canPartition(int[] nums) {
        int volume = 0;
        for(int num : nums) volume += num;
        if(volume % 2 != 0) return false; // choose n items from nums and the sum is volume/2.
        volume /= 2;
        
        boolean[] dp = new boolean[volume + 1]; // 0, 1, 2.., volume
        dp[0] = true;
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = volume; j >= 0; j--) { // if start from j =0, there will be overwrite for dp[j]
                if(j >= nums[i]) dp[j] = dp[j] || dp[j - nums[i]];
                //dp[j] stays if j < nums[j]
            }
        }
        return dp[volume];
    }
}