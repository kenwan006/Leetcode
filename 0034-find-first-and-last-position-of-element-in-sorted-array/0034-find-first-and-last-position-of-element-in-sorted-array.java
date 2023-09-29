class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length, start = -1, end = -1;
        if (n == 0 || target < nums[0] || target > nums[n - 1]) return new int[]{start, end};
        
        start = leftBound(nums, target);
        end = rightBound(nums, target);
        return new int[]{start, end};
    }
    
    //find  leftmost num == target
    private int leftBound(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, res = -1;
        while (lo <= hi) { //should consider lo == hi
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                res = mid;
                hi = mid - 1;
            }
        }
        return res;
    }
    
    //find the right most num == target
    private int rightBound(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                res = mid;
                lo = mid + 1;
            }
        }
        return res;
    }
}