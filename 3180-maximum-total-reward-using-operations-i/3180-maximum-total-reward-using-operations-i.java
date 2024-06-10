class Solution {
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        
        int n = rewardValues.length;
        int m = rewardValues[n - 1]; //max reward
        
        // dp[i][j] - total rewards j can be formed using subsequence before i inclusively
        // the max total reward for a subsequence is no more than 2m
        boolean[][] dp = new boolean[n + 1][2 * m]; 
        for (int i = 0; i <= n; i++) dp[i][0] = true;
        
        for (int i = 1; i <= n; i++) {
            int reward = rewardValues[i - 1];
            for (int j = 0; j < 2 * m; j++) {
                // the reason we have to ensure reward > j - reward is
                // we can select this reward only when the current total j-reward is greater then the reward to be selected
                if (j >= reward && reward > j - reward && dp[i - 1][j - reward]) dp[i][j] = true;
                if (dp[i - 1][j]) dp[i][j] = true;
            }
        }
        
        int max_j = 0;
        for (int j = 0; j < 2 * m; j++) {
            if (dp[n][j]) max_j = j;
        }
        return max_j;
    }
}