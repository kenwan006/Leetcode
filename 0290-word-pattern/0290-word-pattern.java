class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>(); //map letter -> word
        Set<String> seen = new HashSet<>(); //mark if a word has been mapped
        
        int n = s.length(), i = 0, j = 0; //s[i, j] means a single word 
        for (char c : pattern.toCharArray()) {
            if (j > n) return false;
            
            //find each single word in s
            while (j < n && s.charAt(j) != ' ') j++;
            String word = s.substring(i, j);
            i = ++j;
            
            if (map.containsKey(c) && !map.get(c).equals(word)) return false;
            if (!map.containsKey(c) && seen.contains(word)) return false;
            
            map.put(c, word);
            seen.add(word);
        }
        return j == n + 1; //when pattern is all checked, ensure s is all checked as well
    }
}
//Time: O(n); Space: O(m)
