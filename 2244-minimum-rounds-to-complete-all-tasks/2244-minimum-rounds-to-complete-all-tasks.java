class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        
        int res = 0;
        for (int count : map.values()) {
            if (count == 1) {
                return -1;
            } 
            if (count % 3 == 0) {
                res += count / 3;
            } else {
                // count % 3 = 1; (count/3 -1) triplet groups and 2 dual pairs
                // count % 3 = 2; count/3 triplet groups and 1 dual pair
                res += count / 3 + 1;
            }
        }
        return res;
    }
}
//Time: O(n); Space: O(n)
