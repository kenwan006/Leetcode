class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, 0, new HashSet<String>(wordDict), new HashMap<String, List<String>>());
    }
    
    private List<String> wordBreak(String s, int i, HashSet<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s.substring(i))) return map.get(s.substring(i));
        
        List<String> res = new ArrayList<>();
        
        if (i == s.length()) {
            res.add("");
            return res;
        }
        
        
        for (int j = i + 1; j <= s.length(); j++) {
            String word = s.substring(i, j);
            if (wordDict.contains(word)) {
                List<String> sublist = wordBreak(s, j, wordDict, map);
                for (String sub : sublist) {
                    if (sub == "") res.add(word);
                    else res.add(word + " " + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}