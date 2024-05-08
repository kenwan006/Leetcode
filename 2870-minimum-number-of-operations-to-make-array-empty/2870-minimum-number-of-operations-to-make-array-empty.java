class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        int res = 0;
        for (int count : map.values()) {
            if (count == 1) return -1;
            
            res += count % 3 == 0? count / 3 : count / 3 + 1;
        }
        return res;
    }
}