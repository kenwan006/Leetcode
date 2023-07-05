class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>(); // monotonic list
        res.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > res.get(res.size() - 1)) res.add(nums[i]);
            else {
                int idx = search(res, nums[i]); //find position and replace with nums[i]
                res.set(idx, nums[i]);
            }
        }
        return res.size();
    }
    
    //find the smallest number in list greater than or equal to the target
    private int search(List<Integer> list, int target) {
        int lo = 0, hi = list.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (list.get(mid) < target) lo = mid + 1;
            else  hi = mid;
        }
        return lo;
    }
}
//Time: O(n * log(n)); Space: O(n)
