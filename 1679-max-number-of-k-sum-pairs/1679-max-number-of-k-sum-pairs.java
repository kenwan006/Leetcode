class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            if (num >= k) continue;
            
            int bal = k - num;
            if (!map.containsKey(bal) || map.get(bal) < 1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                count++;
                map.put(bal, map.get(bal) - 1);
            }
        }
        return count;
    }
}
//Time: O(n); Space: O(n)
