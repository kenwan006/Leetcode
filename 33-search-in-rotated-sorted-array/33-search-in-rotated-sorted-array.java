class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            
            if (nums[lo] <= nums[mid]) { //left half is sorted
                if (target >= nums[lo] && target < nums[mid]) {//target is between low and middle
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { //right half is sorted
                if(target > nums[mid] && target <= nums[hi]) { // target is between middle and high
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}