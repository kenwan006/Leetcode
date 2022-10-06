/** Binary Search
* Check which half is sorted (in ascending order).
* If the mid > start, it means the left half is sorted; otherwise the right half is sorted
* Binary search
*/
class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            
            if (nums[mid] >= nums[lo]) { // the left half is sorted
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // the right half is sorted
                if (target > nums[mid] && target <= nums[hi]) { // need to include = num[hi]
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}