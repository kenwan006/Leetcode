/** Kadane's Algorithm **/
class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax = nums[0], localMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (localMax < 0) localMax = 0;
            localMax += nums[i];
            globalMax = Math.max(globalMax, localMax);
        }
        return globalMax;
    }
}
//Time: O(n); Space: O(1)
