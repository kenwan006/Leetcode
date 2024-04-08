class Solution {
    Map<Character, String> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    public boolean wordPatternMatch(String pattern, String s) {
        map = new HashMap<>();
        set = new HashSet<>();
        return isMatched(pattern, 0, s, 0);
    }
    
    private boolean isMatched(String p, int pPos, String s, int sPos) {
        if (pPos == p.length() && sPos == s.length()) return true;
        if (pPos == p.length() || sPos == s.length()) return false;
        
        char c = p.charAt(pPos);
        
        //c already checked
        if (map.containsKey(c)) {
            String substr = map.get(c);
            //check if s[sPos..] starts with substr
            if (!s.substring(sPos).startsWith(substr)) return false;
            return isMatched(p, pPos + 1, s, sPos + substr.length());
        }
        
        //c not been checked
        for (int i = sPos; i < s.length(); i++) {
            String substr = s.substring(sPos, i + 1);
            if (set.contains(substr)) continue; //skip if this substr has already been mapped by another char in pattern
            set.add(substr);
            map.put(c, substr);
            if (isMatched(p, pPos + 1, s, i + 1)) return true;
            set.remove(substr);
            map.remove(c);
        }
        return false;
    }
}