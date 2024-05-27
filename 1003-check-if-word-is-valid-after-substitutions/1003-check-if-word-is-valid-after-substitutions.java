class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        while (s.length() > 3) {
            //remove all the "abc" and push the rest to the stack
            int i = 0;
            int n = s.length();
            while (i < n) {
                if (i + 2 < n && s.substring(i, i + 3).equals("abc")) i += 3;
                else stack.push(s.charAt(i++));
            }
            
            //pop out all chars on stack and convert to a string for next check
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            String str = sb.reverse().toString();
            if (str.equals(s)) return false; //no "abc" found, and str is the same is original s
            s = str; //update the s for next check
        }
        return s.isEmpty() || s.equals("abc");
    }
}