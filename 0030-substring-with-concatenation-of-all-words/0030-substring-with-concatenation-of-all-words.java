/** Two HashMap **/
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        } 
        
        int n = s.length(), m = words.length, L = words[0].length();
        
        //check if substing s[i, i + L * m] can be concatenated by the words
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= n - m * L; i++) {
            String str = s.substring(i, i + m * L);
            if (isConcat(str, L, counts)) res.add(i);
        }
        return res;
    }
    
    private boolean isConcat(String s, int wordLen, Map<String, Integer> counts) {
        Map<String, Integer> seen = new HashMap<>();
        for (int i = 0; i <= s.length() - wordLen; i += wordLen) {
            String word = s.substring(i, i + wordLen);
            seen.put(word, seen.getOrDefault(word, 0)  + 1);
            if (!counts.containsKey(word) || seen.get(word) > counts.get(word)) return false;
        }
        return true;
    }
}
//Time: O(n * m); Space: O(n + m)