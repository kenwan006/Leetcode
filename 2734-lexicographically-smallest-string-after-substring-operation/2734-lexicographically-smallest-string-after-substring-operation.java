class Solution {
    public String smallestString(String s) {
        int n = s.length(), i = 0;
        StringBuilder sb = new StringBuilder();
        
         //skip the leading 'a'
        while (i < n && s.charAt(i) == 'a') sb.append(s.charAt(i++));
        
        //stop at the next 'a'
        boolean change = false;
        while (i < n && s.charAt(i) != 'a') {
            char c = s.charAt(i++);
            sb.append((char)(c - 1));
            change = true;
        }
        
        //add the remaining letters
        while (i < n) sb.append(s.charAt(i++));
        
        if (!change) sb.setCharAt(n - 1, 'z');
        return sb.toString();
    }
}
//Time: O(n); Space: O(n)

