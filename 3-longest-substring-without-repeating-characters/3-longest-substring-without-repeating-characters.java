class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0, maxLen = 0;
        for(int j = 0; j < s.length(); j++) {
            if(map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);// update the starting index of sliding window           
            }
            map.put(s.charAt(j), j);
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}
  