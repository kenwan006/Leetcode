class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        int k = target / sum; //repetitions of nums
        if (target % sum == 0) return k * n;
        
        target -= k * sum;
        
        int i = 0, j = 0; //sliding window [i..j]
        int subsum = nums[0], res = Integer.MAX_VALUE;
        while (j < 2 * n) {
            if (subsum == target) {
                res = Math.min(res, j - i + 1);
                subsum -= nums[i % n]; //move left bound
                i++;
            } else if (subsum < target) {
                j++; //move right bound
                subsum += nums[j % n];
                
            } else {
                subsum -= nums[i % n];
                i++; //move left bound
            }
        }
        return res == Integer.MAX_VALUE? -1 : res + k * n;
    }
}
//Time: O(n); Space: O(1)
