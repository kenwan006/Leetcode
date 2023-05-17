/** Two pointer
* keep extending the right bound of the subarray.
* If adding the next num cause the sum to be negative, then skip this num - move the left pointer to the next num
* Otherwise add this num to current sum and move the right  pointer to the next
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0, j = 0, n = nums.length;
        int sum = 0, res = Integer.MIN_VALUE;
        while (j < n) {
            sum += nums[j++];
            res = Math.max(res, sum);
            if (sum < 0) {
                sum = 0;
                i = j;
            }
        }
        return res;
    }
}
//Time: O(n); Space: O(1)