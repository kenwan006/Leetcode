class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n = words.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    res++;
                }
            }
        }
        return res;
    }
    
    private boolean isPrefixAndSuffix(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if (m > n) return false;
        
        if (!s1.equals(s2.substring(0, m)) || !s1.equals(s2.substring(n - m))) return false;
        
        return true;
    }
}