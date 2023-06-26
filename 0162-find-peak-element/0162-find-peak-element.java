/** Binary Search **/
class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) lo = mid + 1;
            else hi = mid;
            //nums[i] != nums[i + 1] for all valid i
        }
        return lo;
    }
}
//Time: O(log(n)); Space: O(1)
