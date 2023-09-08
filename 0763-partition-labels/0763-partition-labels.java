/** Greedy **/
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>(); //map each letter -> farthest position in s
        for (int i = 0; i < n; i++) map.put(s.charAt(i), i);
        
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, map.get(s.charAt(i))); //update the max end of current partition
            if (i == end) {
                res.add(end - start + 1);
                start = end + 1;
            }
        }
        return res;
    }
}
//Time: O(n); Space: O(n)

