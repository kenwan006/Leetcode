class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            if(nums[i] > 0) break; 
            if(i >= 1 && nums[i] == nums[i-1]) continue; //skip the current iteration if next one is same as the previous
            while(lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if(sum > 0) hi--;
                else if(sum < 0) lo++;
                else {
                    result.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                    while(lo < hi && nums[lo] == nums[lo+1]) lo++;
                    while(lo < hi && nums[hi] == nums[hi-1]) hi--;
                    lo++;
                    hi--;
                }
            }
        }
        return result;
    }
}