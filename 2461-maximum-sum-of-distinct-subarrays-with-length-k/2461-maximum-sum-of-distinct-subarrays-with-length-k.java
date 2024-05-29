class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //map num -> its freq
        long max_sum = 0;
        long sub_sum = 0;
        int cnt; //distinct number in the sliding window
        
        //sliding window [i...j]
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            map.put(num, map.getOrDefault(num, 0) + 1);
            sub_sum += num;
            
            //check if we need to remove the most left
            if (j >= k) {
                int i = j - k;
                sub_sum -= nums[i];
                if (map.get(nums[i]) == 1) map.remove(nums[i]);
                else map.put(nums[i], map.get(nums[i]) - 1);
            }
            
            //check if the sliding window has k distinct num
            if (map.size() == k) {
                max_sum = Math.max(max_sum, sub_sum);
            }
        }
        
        return max_sum;
    }
}

//Time: O(n); Space: O(n)
