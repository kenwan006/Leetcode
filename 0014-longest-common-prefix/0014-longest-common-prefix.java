class Solution {
    public String longestCommonPrefix(String[] strs) {
        int end = 0;
        String s = strs[0];
        for (int i = 0; i < s.length(); i++) {
            for (String str : strs) {
                if (str.length() == end || s.charAt(i) != str.charAt(i)) return s.substring(0, end);
            }
            end++;
        }
        return s;
    }
}
//Time: O(m * n); Space: O(1)
