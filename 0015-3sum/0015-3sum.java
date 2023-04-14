/** Two pointers */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicate nums
            int target = -nums[i];
            int lo = i + 1, hi = nums.length - 1;
            
            //2Sum to find the target
            while (lo < hi) {
                int left = nums[lo], right = nums[hi];
                int sum = nums[lo] + nums[hi];
                if (sum < target) {
                    while (lo < hi && nums[lo] == left) lo++;
                } else if (sum > target) {
                    while (lo < hi && nums[hi] == right) hi--;
                } else {
                    res.add(Arrays.asList(nums[i], left, right));
                    while (lo < hi && nums[lo] == left) lo++;
                    while (lo < hi && nums[hi] == right) hi--;
                }
            }
        }
        return res;
    } 
}
//Time: O(n ^ 2); Space: O(n)