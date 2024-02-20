class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArray(0, nums.length - 1, nums);
    }
    
    private int maxSubArray(int lo, int hi, int[] nums) {
        if (hi < lo) return Integer.MIN_VALUE;
        
        int mid = lo + (hi - lo) / 2;
        
        int lsum = 0; // max sum of subarray ending with mid-1
        int sum = 0;
        for (int i = mid - 1; i >= lo; i--) {
            sum += nums[i];
            lsum = Math.max(lsum, sum);
        }
        
        int rsum = 0; // max sum of subarray starting with mid+1
        sum = 0;
        for (int i = mid + 1; i <= hi; i++) {
            sum += nums[i];
            rsum = Math.max(rsum, sum);
        }
        
        sum = lsum + nums[mid] + rsum; //max sum of subarray containing nums[mid]
        
        int lsubarray = maxSubArray(lo, mid - 1, nums); 
        int rsubarray = maxSubArray(mid + 1, hi, nums);
        
        return Math.max(sum, Math.max(lsubarray, rsubarray));
    }
}