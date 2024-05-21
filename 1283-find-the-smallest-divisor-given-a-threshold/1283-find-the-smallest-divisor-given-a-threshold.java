class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int hi = 0;
        for (int num : nums) {
            hi = Math.max(hi, num);
        }
        
        int lo = 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int x = sumDivisions(mid, nums);
            if (x > threshold) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
    
    private int sumDivisions(int divisor, int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) (Math.ceil(num * 1.0 / divisor));
        }
        
        return sum;
    }
}