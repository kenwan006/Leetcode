class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        /**
        * Find the min distance and max distance, then then binary search
        * count the pairs whoes distances <= mid, and compare the count with k
        */
        Arrays.sort(nums);
        
        int minDist = 1000000, n = nums.length;
        for (int i = 1; i < n; i++) {
            minDist = Math.min(minDist, nums[i] - nums[i - 1]);
        }
        
        int lo = minDist, hi = nums[n - 1] - nums[0];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int ctn = count(nums, mid);
            if (ctn < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    
    //count pair(num1, nums), whose distance <= target
    private int count(int[] nums, int target) {
        int ctn = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j++] - nums[i] <= target) ctn++;
        }
        return ctn;
    }
}

//Time: O(n * n * log(m)); Space: O(1)