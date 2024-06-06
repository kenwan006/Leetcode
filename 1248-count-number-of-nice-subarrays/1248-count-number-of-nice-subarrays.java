class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //change all even nums to 0, and odd to 1
        int n = nums.length;
        for (int i = 0; i < n; i++) nums[i] = nums[i] % 2 == 1? 1 : 0;
        
        //calculate the prefix sum and use a hashmap to store its freq
        Map<Integer, Integer> map = new HashMap<>(); 
        int res = 0;
        int prefix = 0;
        for (int num : nums) {
            prefix += num;
            if (prefix == k) res++;
            res += map.getOrDefault(prefix - k, 0);
            map.put(prefix, map.getOrDefault(prefix, 0) + 1); //update the freq of this freq in map
        }
        
        return res;
    }
}