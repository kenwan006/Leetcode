/** Binary search
* Since every num appear twice expect for one that appreas once, so the total number would be odd
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, mid = 0, hi = nums.length - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            boolean evenHalf = (mid - lo) % 2 == 0; //each half has even numbers
            if (nums[mid] == nums[mid - 1]) {
                if (evenHalf) hi = mid - 2;
                else lo = mid + 1;
            } else if (nums[mid] == nums[mid + 1]) {
                if (evenHalf) lo = mid + 2;
                else hi = mid - 1;
            } else {
                return nums[mid];
            }
        }
        return nums[lo];
    }
}
//Time: O(log(n)); Space: O(1)


