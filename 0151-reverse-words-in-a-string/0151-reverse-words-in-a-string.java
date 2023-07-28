class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            //remove the spaces between two words
            while (i >= 0 && s.charAt(i) == ' ') i--;
            
            if (i < 0) break; //reaches the leading space
            
            //find the start and end index of each word
            int j = i + 1;
            while (i >= 0 && s.charAt(i) != ' ') i--;
            
            sb.append(s.substring(i + 1, j)).append(' ');
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
//Time: O(n); Space: O(n)

