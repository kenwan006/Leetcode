class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        /**
        * Find the min distance and max distance, then then binary search
        * count the pairs whoes distances <= mid, and compare the count with k
        */
        Arrays.sort(nums);
        int n = nums.length;
        int lo = 0, hi = nums[n - 1] - nums[0];
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
    private int count(int[] nums, int dist) {
        /**
        * say we have a pair - {nums[i], nums[j]}, find the upperbound of j such that
        * each nums[j] - nums[i] <= dist
        */
        int ctn = 0;
        for (int i = 0; i < nums.length; i++) {
            int upperBound = firstGreaterThan(nums, nums[i] + dist);
            ctn += upperBound - i - 1;
        }
        return ctn;
    }
    
    //find the first num > target
    private int firstGreaterThan(int[] nums, int target) {
        int lo = 0, hi = nums.length; //don't use nums.length - 1
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

//Time: O(nlog(n) + n * log(m) * log(m)); Space: O(1)