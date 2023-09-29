class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(); //map num -> occurence
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        Set<Integer> set = new HashSet<>();
        for (int occur : map.values()) {
            if (set.contains(occur)) return false;
            else set.add(occur);
        }
        
        return true;
    }
}
//Time: O(n); Space: O(n)

