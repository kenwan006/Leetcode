class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip the duplicate for the first num
            int target = -nums[i];
            
            //chose the second and third num whose sum is -nums[i]
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum < target) {
                    lo++;
                } else if (sum > target) {
                    hi--;
                } else {
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    
                    lo++;
                    hi--;
                }
            }
        }
        return res;
    }
}