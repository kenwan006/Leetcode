/** Sliding window **/
class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        long sum = 0;
        for (int num : nums) sum += num;
        int k = (int) (target / sum); //repetition of nums
        if (target % sum == 0) return k * n;
        
        target %= sum;
        
        Map<Long, Integer> map = new HashMap<>(); //map sum of prefix - nums[0..i] to i
        map.put(0L, -1); 
        int res = Integer.MAX_VALUE;
        long prefix = 0;
        for (int i = 0; i < 2 * n; i++) { //expand the range to 2n
            prefix += (long)nums[i % n];
            if (map.containsKey(prefix - target)) {
                res = Math.min(res, i - map.get(prefix - target));
            }
            map.put(prefix, i);
        }
        return res == Integer.MAX_VALUE? -1 : res + n * k;  
    }
}
//Time: O(n); Space: O(1)
