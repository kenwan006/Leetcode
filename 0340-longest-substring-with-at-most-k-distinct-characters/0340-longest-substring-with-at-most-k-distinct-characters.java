class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max_len = 0;
        int l = 0; //left bound of sliding window
        Map<Character, Integer> map = new HashMap<>(); //rightmost postion of each char in the sliding window
        
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
            if (map.size() > k) {
                //remove the char whose right most position is smallest in these k chars
                int del_idx = getIndex(map);
                map.remove(s.charAt(del_idx));
                l = del_idx + 1;
            }
            max_len = Math.max(max_len, i - l + 1);
        }
        return max_len;
    }
    
    private int getIndex(Map<Character, Integer> map) {
        int min_idx = 50001;
        for (int idx : map.values()) min_idx = Math.min(min_idx, idx);
        return min_idx;
    }
}