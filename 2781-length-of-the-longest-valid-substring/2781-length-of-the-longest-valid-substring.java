class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String> wordDict = new HashSet<>();
        for (String w : forbidden) wordDict.add(w);
        
        //slidig window [left, right], moving from right end
        int n = word.length(), maxRight = n - 1;
        int maxLen = 0;
        for (int left = n - 1; left >= 0; left--) {
            for (int right = left; right <= Math.min(maxRight, left + 9); right++) {
                String sub = word.substring(left, right + 1);
                if (wordDict.contains(sub)) {
                    /**
                    * if we find forbidden word in the substring starting with left word[left,..]
                    * then break and update the next max right bound to right - 1;
                    */
                    maxRight = right - 1; 
                }
            }
            maxLen = Math.max(maxLen, maxRight - left + 1);
        }
        
        return maxLen;
    }
}