We have to consider whether a num should be added into the contiguous subarray.
case a: An array [... , -1, 2,...], with a subarray [ -1, 2]. If the next number is -1 then we have to include this number into the array --> [-1, 2,-1] because the sum is greater than the number itself, i,e, 0 > -1
case b: An array [... ,1, -3,...], with a subarray [1, -3].  If the next number is -1, then we have to give up the array [1, -3]. If we add -1 to the subarray [1,-3] -->[1,-3,-1], then its sum would be smaller than the number itself, i.e. -3 < -1. In this case we have to update the subarry to[-1]
​
The format is
If dp[i - 1] < 0, dp[i]  = nums[i]; otherwise dp[i] = dp[i-1] + nums[i];
dp[i] represents the largest sum of the subarray ending with item num[i];