class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 3; i++) {
            if (nums[i] > 0 && nums[i] > target) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < n - 2; j++) {
                if (nums[j] > 0 && nums[i] + nums[j] > target) break;
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                //2Sum
                int lo = j + 1, hi = n - 1;
                while (lo < hi) {
                    long sum = (long) nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (sum < target) {
                        lo++;
                    } else if (sum > target) {
                        hi--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                        lo++; hi--;
                    }
                }
            }
        }
        return res;
    }
}
//Time: O(n ^ 3); Space: O(1)