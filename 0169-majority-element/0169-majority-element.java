/** Divide & conquer **/
class Solution {
    public int majorityElement(int[] nums) {
        return majorityElement(nums, 0, nums.length - 1);
    }
    
    public int majorityElement(int[] nums, int lo, int hi) {
        if (lo == hi) return nums[lo];
        
        int mid  = lo + (hi - lo) / 2;
        int left = majorityElement(nums, lo, mid);
        int right = majorityElement(nums, mid + 1, hi);
        
        if (left == right) return left; //when both halves have the sames majority element
        
        //check the count of "left" and "right" appearing in the entire nums
        int countl = count(nums, lo, hi, left);
        int countr = count(nums, lo, hi, right);
        return countl > countr? left : right;
    }
    
    public int count(int[] nums, int lo, int hi, int element) {
        int ctn = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == element) ctn++;
        }
        return ctn;
    }
}
//Time: O(n * log(n)); Space: O(1)
