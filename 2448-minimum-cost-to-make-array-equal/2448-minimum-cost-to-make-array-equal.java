/** Binary Search **
* f(x) - the total cost needed to make all nums become x
* Binary search can be used for this problem only based on the fact that f(x) is a convex function
* if f(x) > f(x + 1), then go to right of x for the target, otherwise go to left
*/
class Solution {
    public long minCost(int[] nums, int[] cost) {
        //init boundary of binary search
        int lo = 1000000, hi = 0;
        for (int num : nums) {
            lo = Math.min(lo, num);
            hi = Math.max(hi, num);
        }
        
        //binary search
        long res = 0;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long cost1 = totalCost(nums, cost, mid);
            long cost2 = totalCost(nums, cost, mid + 1);
            res = Math.min(cost1, cost2);
            if (cost1 > cost2) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return res;
    }
    
    private long totalCost(int[] nums, int[] cost, int x) {
        long total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += 1L * Math.abs(nums[i] - x) * cost[i]; // covert to long type
        }
        return total;
    }
}
//Time: O(n * log(k)); Space: O(1), k - diff between max num and min num