/** Binary Search + greedy *
** If we have a target that sum of any subarrays cannot exceed;
** Iterate over the nums, keep adding the num, if the sum > target, then count++ and reset sum = 0.
** If we have count > k at last, it means this target is too large, so we have to increase the lower bound.
** If we have count <= k at last, it means this target is too small, so we have to decrease the upper bound.
*/
class Solution {
    public int splitArray(int[] nums, int k) {
        //find the lower and upper bound
        int lo = 0, hi = 0;
        for (int num : nums) {
            lo = Math.max(lo, num);
            hi += num;
        }
        
        //binary search
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 1; //count of subarrays
            int sum = 0; //sum of the current subarray
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] <= mid) {
                    sum += nums[i];
                }
                else {
                    count++;
                    sum = nums[i];
                }
            }
            if (count <= k) hi = mid;
            else lo = mid + 1;
        }
        return lo;
    }
}

//Time: O(n * log(sum); Space: O(1)