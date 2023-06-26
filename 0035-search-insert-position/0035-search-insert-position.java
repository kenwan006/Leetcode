class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        if (target > nums[n - 1]) return n;
        if (target < nums[0]) return 0;
        
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) lo = mid + 1;
            else hi = mid; //hi is the candidate
        }
        return lo;
    }
}
//Time: O(log(n)); Space: O(1)
