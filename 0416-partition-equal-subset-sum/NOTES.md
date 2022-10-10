Backpack problem - Dynamic Programming
​
choose items from nums[0],..nums[i] to fill the a bag of volume j;
Either choose nums[i], then dp[i][j] = dp[i-1][j - nums[j]],
- or not choose nums[i], then dp[i][j] = dp[i-1][j]
​
/** DP
* dp[i][j] - means if we can choose item from nums[0]..nums[i] to fill up the bag of volume = j
* To fill up the volume j evenly using item nums[0]..nums[i],
we either pick nums[i], then we have to use nums[0]..nums[i-1] to fill up j - num[i] evenly;
or we don't pick nums[i], then we have to use nums[0]..num[i] to fill up j evenly
* dp[i][j] = dp[i-1][j] || dp[i-1][j - nums[i]]
*/
​