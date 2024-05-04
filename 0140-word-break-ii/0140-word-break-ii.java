class Solution {
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, List<String>> map = new HashMap<>();
        return wordBreak(s, wordDict, map);
    }
    
    private List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        
        List<String> res = new ArrayList<>();
        if (s == "") {
            res.add("");
            return res;
        }
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = wordBreak(s.substring(word.length()), wordDict, map);
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