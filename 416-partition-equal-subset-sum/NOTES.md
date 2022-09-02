Backpack problem - Dynamic Programming
​
choose items from nums[0],..nums[i] to fill the a bag of volume j;
Either choose nums[i], then dp[i][j] = dp[i-1][j - nums[j]],
- or not choose nums[i], then dp[i][j] = dp[i-1][j]