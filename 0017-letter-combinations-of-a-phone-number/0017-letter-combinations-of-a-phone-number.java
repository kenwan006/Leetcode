/** Backtracking
- The digit at ith position of digits maps to a string.
- For loop to check each letter of the string.
  - Every time check one letter, add it to the track,increment start index i by one 
  - Implement function of backtrack 
  - Once backtrack is done, remove the letter from the track

*/

class Solution {
    String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new LinkedList<>();
    StringBuilder track = new StringBuilder();
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        StringBuilder track = new StringBuilder();
        backtrack(digits, 0);
        return res;
    }
    
    public void backtrack(String digits, int i) { //i means ith digit in the digits
        // base case
        if (track.length() == digits.length()) {
            res.add(track.toString());
            return;
        }
        
        String s = mapping[digits.charAt(i) - '0'];
        for (char ch : s.toCharArray()) {
            track.append(ch);
            backtrack(digits, i + 1); 
            track.deleteCharAt(track.length() - 1);
        }
        
    }
     
}