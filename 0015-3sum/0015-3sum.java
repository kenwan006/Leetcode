class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            //chose the 1st num
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            if (nums[i] > 0) continue;
            int target = -nums[i];
            
            //2sum for 2nd  and 3rd num
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] < target){
                    lo++;
                } else if (nums[lo] + nums[hi] > target) {
                    hi--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    hi--;
                    lo++;
                }
            }
        }
        return res;
    }
}