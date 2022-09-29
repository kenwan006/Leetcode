/** Sliding window
* Use a sliding window constrained by start index i and end index j
* Use a hashmap to map each character to its most latest position
* Check the next letter by incrementing j. If it's not in the hashmap, add it to the hashmap, and update the max length; 
* If it's already in the hashmap, chekc if it's wintin the window. i = max{i, map.get(ch) + 1}.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for (int j = 0; j < s.length(); j++) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) 
                i = Math.max(i, map.get(ch) + 1);
            map.put(ch, j);
            maxLen = Math.max(maxLen, j - i + 1); //update the maxLen after each iteration
        }
        return maxLen;
    }
}