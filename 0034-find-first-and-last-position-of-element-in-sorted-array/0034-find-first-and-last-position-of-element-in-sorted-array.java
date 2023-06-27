class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1]) return res;
        
        int lo = 0, mid = 0, hi = nums.length - 1;
        
        //find the first one
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) lo = mid + 1;
            else hi = mid - 1; //try to push the right bound to the left
        }
        if (nums[lo] == target) res[0] = lo;
        
        //find the last one
        lo = 0; hi = nums.length - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) hi = mid - 1;
            else lo = mid + 1;
           
        }
        if (nums[hi] == target) res[1] = hi;
        
        return res;
    }
}
//Time: O(log(n)); Space: O(1)