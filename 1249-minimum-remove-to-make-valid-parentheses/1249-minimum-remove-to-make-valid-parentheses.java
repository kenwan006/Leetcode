class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0; // remaining '('
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            if (c == ')') count--;
            
            if (count >= 0) stack.push(c);
            else count = 0;  //we should not have ')' more than '('
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(' && count > 0) count--; //remove the remaining '('
            else sb.append(c);
        }
        return sb.reverse().toString();
    }
}