/** Two pointer **/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //Check 1st item, skip the duplicate 
            
            //2-sum
            int lo = i + 1, hi = nums.length - 1, target = -nums[i];
            while (lo < hi) {
                int sum = nums[lo] + nums[hi];
                if (sum > target) hi--;
                else if (sum < target) lo++;
                else {
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++; //Check 2nd item, skip the duplicate 
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--; //Check 3rd item, skip the duplicate 
                    res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                }
            }
        }
        return res;
    }
}
//Time: O(n * n); Space: O(n)

