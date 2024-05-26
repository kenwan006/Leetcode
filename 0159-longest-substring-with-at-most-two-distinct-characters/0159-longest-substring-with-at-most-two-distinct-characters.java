class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max_len = 1;
        Map<Character, Integer> map = new HashMap<>(); //rightmost position of each char in the sliding window
        
        int l = 0; //left bound of the sliding window
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
            if (map.size() > 2) { //if the size is 3, then remove the char whose right most position is smallest
                int del_idx = getIndex(map);
                map.remove(s.charAt(del_idx));
                l = del_idx + 1;
            }
            max_len = Math.max(max_len, i - l + 1);
        }
        return max_len;
    }
    
    private int getIndex(Map<Character, Integer> map) {
        int min_idx = 100001;
        for (int idx : map.values()) min_idx = Math.min(min_idx, idx);
        return min_idx;
    }
}