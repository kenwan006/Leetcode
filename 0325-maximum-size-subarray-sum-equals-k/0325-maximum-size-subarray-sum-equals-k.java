class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        //prefix sum + hashMap
        int prefix = 0;
        Map<Integer, Integer> map = new HashMap<>(); //map prefix sum -> idx of the prefix
        
        int max_len = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            
            
            if (!map.containsKey(prefix)) map.put(prefix, i); //store the `smallest` idx for the same prefix sum
            
            if (prefix == k) max_len = i + 1; //check if the current prefix sum equals to k
            else {
                int complement = prefix - k;
                if (map.containsKey(complement)) {
                    max_len = Math.max(max_len, i - map.get(complement));
                }
            }
            
        }
        return max_len;
    }
}