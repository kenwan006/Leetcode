/** Backtracking 
* Vertically, check each char of pattern 
* Horizontally, check each substring of s, which is s[sPos, i], i range (sPos, s.length())
*/
class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        return isMatch(pattern, 0, s, 0, map);
    }
    
    public boolean isMatch(String p, int pPos, String s, int sPos, Map<Character, String> map) {
        if (pPos == p.length() && sPos == s.length()) return true;
        if (pPos == p.length() || sPos == s.length()) return false;
    
        char c = p.charAt(pPos);
        for (int i = sPos; i < s.length(); i++) {
            String substr = s.substring(sPos, i + 1);
            
            if (map.containsKey(c) && map.get(c).equals(substr)) {
                return isMatch(p, pPos + 1, s, i + 1, map);
            }
            
            if (!map.containsKey(c) && !map.containsValue(substr)) { //ensure this substring not been mapped by another char in pattern
                map.put(c, substr);
                if (isMatch(p, pPos + 1, s, i + 1, map)) return true;
                map.remove(c);
            }
        }
        return false;
    }
}