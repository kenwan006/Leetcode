/** Two pointers + Recursioin
* General solution to the nSum problem for a sorted array.
* Iterate over the array, pick the item at ith position, then one need to find (n-1) numbers that sum up to (target - nums[i]) in the range nums[i+1, end]
* The base case is a 2Sum problem. One can easily solve this using two pointers.
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 0, 4, target);
    }
    
    //Return nSum with the specific target and start index
    public List<List<Integer>> nSum(int[] nums, int start, int n, long target) {
        List<List<Integer>> res = new ArrayList<>();
        //base case is 2Sum
        if (n == 2) {
            int lo = start, hi = nums.length - 1;
            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(nums[lo]);
                    pair.add(nums[hi]);
                    res.add(pair);
                    while (lo < hi && nums[lo] == nums[lo + 1]) lo++; //skip duplicate numbers
                    while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                    lo++;
                    hi--;
                } else if (nums[lo] + nums[hi] < target) {
                    lo++;
                } else {
                    hi--;
                }
            }
        } else {
            for (int i = start; i <= nums.length - n; i++) {
                //Run recursion- pick a nums[i], and get the (n-1)Sum with the new target = target-nums[i] 
                List<List<Integer>> lists = nSum(nums, i + 1, n - 1, target - nums[i]);
                
                //add the nums[i] back to the (n-1)Sum list to get a nSum list
                for (List<Integer> list : lists) {
                    list.add(0, nums[i]);
                    res.add(list);
                }
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++; //skip duplicate numbers
            }
        }
        
        return res;
    }
}
//Time: O(n ^ 3); Space: O(n)