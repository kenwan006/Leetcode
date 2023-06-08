class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>(); 
        Set<Character> seen = new HashSet<>(); //mark if char in t has been mapped
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2)  return false;
            if (!map.containsKey(c1) && seen.contains(c2)) return false;
            map.put(c1, c2);
            seen.add(c2);
        }
        return true;
    }
}
//Time: O(n); Space: O(1)
