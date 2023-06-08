class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>(); //map letter -> word
        Set<String> seen = new HashSet<>(); //mark if a word has been mapped
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            if (map.containsKey(c) && !map.get(c).equals(word)) return false;
            if (!map.containsKey(c) && seen.contains(word)) return false;
            map.put(c, word);
            seen.add(word);
        }
        return true;
    }
}
//Time: O(n + m); Space: O(m)
