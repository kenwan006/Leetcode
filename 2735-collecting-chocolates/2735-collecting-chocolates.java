/** Rotate Array *
* There are at most n times rotations.
* When we rotate k times, get the min collection cost of each type chocolate, sum them up and get sum[k]
*/
class Solution {
    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[] costs = new int[n]; // cost[i] - refers to the min cost of ith type chocolate
        for (int i = 0; i < n; i++) costs[i] = nums[i];
        
        long res = Long.MAX_VALUE;
        for (int k = 0; k < n; k++) {
            long sum = (long) k * x; //sum refers to min total cost when rotate k times
            for (int i = 0; i < n; i++) {
                costs[i] = Math.min(costs[i], nums[(i + k) % n]);
                sum += costs[i];
            }
            res = Math.min(res, sum);
        }
        return res;
    }
}
//Time: O(n * n); Space: O(n)
