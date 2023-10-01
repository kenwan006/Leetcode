class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length, sum = 0;
        for (int num : nums) sum += num;
        int N = (target / sum + 2) * n;
        
        int i = 0, j = 0; //sliding window [i..j]
        int subsum = nums[0], res = Integer.MAX_VALUE;
        while (j < N) {
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
        return res == Integer.MAX_VALUE? -1 : res;
    }
}
//Time: O(n); Space: O(1)
