/* Two pointers + Sliding window
** Use two poniters - start and end starting from 0
** Move end until find a valid window, which contains all char in string t
** Move start one by one to shirnk the window
** Repeate the above 2 steps
*/
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || s.length() < t.length()) return "";
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : t.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        
        int start = 0, end = 0, count = t.length(), minStart = 0, minLen = Integer.MAX_VALUE;
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map.containsKey(c1)) {
                if (map.get(c1) > 0) count--;
                map.put(c1, map.get(c1)- 1);
            }
            end++;
            
            // shrink the window
            while (count == 0) { 
                char c2 = s.charAt(start);
                // record the min length of valid window and its start index
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                
                if (map.containsKey(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if (map.get(c2) >= 1) count++;// This is where shrink stops when count == 1
                }
                start++;
            }
        }
        
        if (minLen == Integer.MAX_VALUE) return "";
        return s.substring(minStart, minStart + minLen); 
    }
}