/** Two pointers
* sort the nums first;
* fix one number,num[i],  and use two pointer lo and hi to represent the other two candidates
*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>(); // avoid adding repeated list to the result
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum > 0) hi--;
                else if (sum < 0) lo++;
                else res.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
            }
        }
        return new ArrayList<>(res);
    }
}