/** Backtracking
- The digit at ith position of digits maps to a string.
- For loop to check each letter of the string.
  - Every time check one letter, add it to the track,increment start by one 
  - Implement function of backtrack 
  - Once backtrack is done, remove the letter from the track

*/

class Solution {
    String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new LinkedList<>();
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        StringBuilder track = new StringBuilder();
        backtrack(digits, 0, track);
        return res;
    }
    
    public void backtrack(String digits, int start, StringBuilder track) {
        // base case
        if (track.length() == digits.length()) {
            res.add(track.toString());
            return;
        }
        
        String s = mapping[digits.charAt(start) - '0'];
        for (char ch : s.toCharArray()) {
            track.append(ch);
            backtrack(digits, start + 1, track);
            track.deleteCharAt(track.length() - 1);
        }
        
    }
     
}
