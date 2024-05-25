class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum >= target) {
                    hi--;
                } else {
                    res += (hi - lo); //1st- nums[i], 2nd - nums[lo], 3rd - range nums[lo + 1, hi];
                    lo++;
                }
            }
        }
        return res;
    }
}