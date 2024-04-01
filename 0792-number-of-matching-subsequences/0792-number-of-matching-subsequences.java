class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);

        for (String word : map.keySet()) {
            if (match(s, word)) count+= map.get(word);
        }
        return count;
    }
    
    //check if string t is subsequence of string s
    private boolean match(String s, String t) {
        int m = t.length(), n = s.length();
        if (m > n) return false;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(j)) j++;
            if (j == m) return true;
        }
        return false;
    }
}