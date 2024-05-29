class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //map num -> its freq
        long max_sum = 0;
        long sub_sum = 0;
        int cnt = 0; //distinct number in the sliding window
        
        //sliding window [i...j]
        for (int j = 0; j < nums.length; j++) {
            int num = nums[j];
            if (!map.containsKey(num) || map.get(num) == 0) cnt++;
            map.put(num, map.getOrDefault(num, 0) + 1);
            sub_sum += num;
            
            //check if we need to remove the most left
            if (j >= k) {
                int lnum = nums[j - k];
                map.put(lnum, map.get(lnum) - 1);
                sub_sum -= lnum;
                if (map.get(lnum) == 0) cnt--;
            }
            
            //check if the sliding window has k distinct num
            if (cnt == k) {
                max_sum = Math.max(max_sum, sub_sum);
            }
        }
        
        return max_sum;
    }
}

//Time: O(n); Space: O(n)
