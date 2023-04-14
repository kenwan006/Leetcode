/** Two pointers */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicate nums
            int lo = i + 1, hi = nums.length - 1;
            
            //2Sum to find the target
            while (lo < hi) {
                int sum = nums[lo] + nums[hi] + nums[i];
                if (sum < 0) {
                    lo++;
                } else if (sum > 0) {
                    hi--;
                } else {
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++; //skip duplicate nums
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--; //skip duplicate nums
                    res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                }
            }
        }
        return res;
    } 
}
//Time: O(n ^ 2); Space: O(n)