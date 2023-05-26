/** Binary search
* Since every num appear twice expect for one that appreas once, so the total number would be odd
*/
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, mid = 0, hi = nums.length - 1;
        while (lo < hi) {
            mid = lo + (hi - lo) / 2;
            
            //if the half is odd, mid-- so that left half and right half both have even numbers
            if (mid % 2 == 1) mid--; 
            
            if (nums[mid] == nums[mid + 1]) lo = mid + 2;
            else hi = mid;
        }
        return nums[lo];
    }
}
//Time: O(log(n)); Space: O(1)


