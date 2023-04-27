class Solution {
    String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> res = new LinkedList<>();
    StringBuilder sb = new StringBuilder();
    
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(digits, 0);
        return res;
    }
    
    public void backtrack(String digits, int i) { //ith digit
        if (i == digits.length()) {
            res.add(sb.toString());
            return;
        }
        
        int digit = Character.getNumericValue(digits.charAt(i));
        
        for (char c : dict[digit].toCharArray()) {
            sb.append(c);
            backtrack(digits, i + 1); //do not use i++
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}